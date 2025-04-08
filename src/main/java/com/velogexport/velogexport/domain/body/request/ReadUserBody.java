package com.velogexport.velogexport.domain.body.request;

import com.velogexport.velogexport.domain.GraphQLQuery;
import com.velogexport.velogexport.domain.body.GraphQLBody;

public class ReadUserBody extends GraphQLBody {
    public ReadUserBody(GraphQLQuery query, String username) {
        super(query, username);
    }
}
