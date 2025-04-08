package com.velogexport.velogexport.domain.body.request;

import com.velogexport.velogexport.domain.GraphQLQuery;
import com.velogexport.velogexport.domain.body.GraphQLBody;

public class ReadPostBody extends GraphQLBody {
    public ReadPostBody(GraphQLQuery query, String username, String urlSlug) {
        super(query, username, urlSlug);
    }
}
