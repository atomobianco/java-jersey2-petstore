package com.example.api.controller;

import javax.ws.rs.core.UriInfo;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("unchecked")
public class CollectionResource extends Link {

    public static final int DEFAULT_LIMIT = 25;

    public CollectionResource(UriInfo info, String subPath, Collection c) {
        this(info, subPath, c, 0, getLimit(c));
    }

    public CollectionResource(UriInfo info, String subPath, Collection c, int offset, int limit) {
        super(info, subPath);
        put("offset", offset);
        put("limit", getLimit(limit));
        put("items", c != null ? c : Collections.emptyList());
    }

    private static int getLimit(Collection c) {
        return getLimit(c != null ? c.size() : 0);
    }

    private static int getLimit(int limit) {
        return Math.max(DEFAULT_LIMIT, limit);
    }

}
