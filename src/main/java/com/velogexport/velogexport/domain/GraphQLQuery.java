package com.velogexport.velogexport.domain;

public enum GraphQLQuery {
    READ_USER("""
            query getUserFollowInfo($input: GetUserInput!) {
              user(input: $input) {
                id
                username
                profile {
                  id
                  display_name
                  short_bio
                  thumbnail
                  profile_links
                }
                followers_count
                followings_count
                is_followed
              }
            }
            """),
    READ_POSTS("""
            query velogPosts($input: GetPostsInput!) {
              posts(input: $input) {
                id
                title
                short_description
                thumbnail
                user {
                  id
                  username
                  profile {
                    id
                    thumbnail
                    display_name
                  }
                }
                url_slug
                released_at
                updated_at
                comments_count
                tags
                is_private
                likes
              }
            }
            """), READ_POST("""
                query ReadPost($username: String, $url_slug: String) {
                      post(username: $username, url_slug: $url_slug) {
                        id
                        title
                        released_at
                        updated_at
                        tags
                        body
                        short_description
                        is_markdown
                        is_private
                        is_temp
                        thumbnail
                        comments_count
                        url_slug
                        likes
                        liked
                        user {
                          id
                          username
                          profile {
                            id
                            display_name
                            thumbnail
                            short_bio
                            profile_links
                            __typename
                          }
                          velog_config {
                            title
                            __typename
                          }
                          __typename
                        }
                        comments {
                          id
                          user {
                            id
                            username
                            profile {
                              id
                              thumbnail
                              __typename
                            }
                            __typename
                          }
                          text
                          replies_count
                          level
                          created_at
                          level
                          deleted
                          __typename
                        }
                        series {
                          id
                          name
                          url_slug
                          series_posts {
                            id
                            post {
                              id
                              title
                              url_slug
                              user {
                                id
                                username
                                __typename
                              }
                              __typename
                            }
                            __typename
                          }
                          __typename
                        }
                        linked_posts {
                          previous {
                            id
                            title
                            url_slug
                            user {
                              id
                              username
                              __typename
                            }
                            __typename
                          }
                          next {
                            id
                            title
                            url_slug
                            user {
                              id
                              username
                              __typename
                            }
                            __typename
                          }
                          __typename
                        }
                        __typename
                      }
                    }
            """);

    private String query;

    GraphQLQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
