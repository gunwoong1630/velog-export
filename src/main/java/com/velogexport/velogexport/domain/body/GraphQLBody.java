package com.velogexport.velogexport.domain.body;

import com.velogexport.velogexport.domain.GraphQLQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class GraphQLBody {
    private String operationName;
    private String query;
    private Map<String, Object> variables;

    public GraphQLBody(GraphQLQuery query, String username) {
        this.query = query.getQuery();
        Map<String, Object> input = new HashMap<>();
        input.put("username", username);
        Map<String, Object> variables = new HashMap<>();
        variables.put("input", input);
        this.variables = variables;
    }

    public GraphQLBody(GraphQLQuery query, String username, Optional<String> cursor) {
        this.query = query.getQuery();
        Map<String, Object> input = new HashMap<>();
        input.put("username", username);
        if (cursor.isPresent()) {
            input.put("cursor", cursor.get());
        }
        input.put("limit", 100);

        Map<String, Object> variables = new HashMap<>();
        variables.put("input", input);
        this.variables = variables;
    }

    public GraphQLBody(GraphQLQuery query, String username, String urlSlug) {
        this.operationName = "ReadPost";
        this.query = query.getQuery();
        Map<String, Object> variables = new HashMap<>();
        variables.put("username", username);
        variables.put("url_slug", urlSlug);
        this.variables = variables;
    }


}
