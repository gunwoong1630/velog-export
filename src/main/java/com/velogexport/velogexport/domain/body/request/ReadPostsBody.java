package com.velogexport.velogexport.domain.body.request;

import com.velogexport.velogexport.domain.GraphQLQuery;
import com.velogexport.velogexport.domain.body.GraphQLBody;

import java.util.Optional;

public class ReadPostsBody extends GraphQLBody {
    public ReadPostsBody(GraphQLQuery query, String username, Optional<String> cursor) {
        super(query, username, cursor);
    }
}
