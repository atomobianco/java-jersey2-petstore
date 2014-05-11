package com.example.api.controller;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;

@SuppressWarnings("unchecked")
@ApiModel(value = "Collection", description = "Collection of basic resources", parent = LinkedHashMap.class)
public class CollectionResource extends Link {

    public static final int DEFAULT_LIMIT = 25;

    @ApiModelProperty(value = "Collection URI", position = 1) public String getHref() { return super.getHref(); }
    @ApiModelProperty(value = "Collection offset", position = 2) public int getOffset() { return (int) get("offset"); }
    @ApiModelProperty(value = "Collection limit", position = 3) public int getLimit() { return (int) get("limit"); }
    @ApiModelProperty(value = "Collection items", position = 4) public Link[] getItems() { return (Link[])((Collection)get("items")).toArray(); }

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
