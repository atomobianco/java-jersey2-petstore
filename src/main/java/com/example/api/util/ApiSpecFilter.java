package com.example.api.util;

import com.wordnik.swagger.model.*;
import com.wordnik.swagger.core.filter.SwaggerSpecFilter;

import java.util.List;
import java.util.Map;

public class ApiSpecFilter implements SwaggerSpecFilter {

    public boolean isOperationAllowed(Operation operation, ApiDescription api, Map<String, List<String>> params, Map<String, String> cookies, Map<String, List<String>> headers) {
        return true;
    }

    public boolean isParamAllowed(Parameter parameter, Operation operation, ApiDescription api, Map<String, List<String>> params, Map<String, String> cookies, Map<String, List<String>> headers) {
        if((parameter.paramAccess().isDefined() && parameter.paramAccess().get().equals("internal")))
            return false;
        else
            return true;
    }

}
