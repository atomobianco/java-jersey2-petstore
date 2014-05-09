package com.example.api.controller;

import com.example.api.entity.Entity;

import javax.ws.rs.core.UriInfo;
import java.util.LinkedHashMap;

@SuppressWarnings("unchecked")
public class Link extends LinkedHashMap {

    public static final String PATH_SEPARATOR = "/";

    public static final String TODOS = PATH_SEPARATOR + "todos";
    public static final String USERS = PATH_SEPARATOR + "users";
    public static final String PETS  = PATH_SEPARATOR + "pets";

    public Link(UriInfo info, Entity entity) {
        this(getFullyQualifiedContextPath(info), entity);
    }

    public Link(String fqBasePath, Entity entity) {
        String href = createHref(fqBasePath, entity);
        put("href", href);
        if (entity.getType() != null) put("type", entity.getType());
    }

    public Link(UriInfo info, String subPath) {
        this(getFullyQualifiedContextPath(info), subPath);
    }

    public Link(String fqBasePath, String subPath) {
        String href = fqBasePath + subPath;
        put("href", href);
    }

    public String getHref() { return (String) get("href"); }

    protected static String getFullyQualifiedContextPath(UriInfo info) {
        String fq = info.getBaseUri().toString();
        if (fq.endsWith("/")) {
            return fq.substring(0, fq.length()-1);
        }
        return fq;
    }

    protected String createHref(String fqBasePath, Entity entity) {
        StringBuilder sb = new StringBuilder(fqBasePath);
        ResourcePath path = ResourcePath.forClass(entity.getClass());
        sb.append(path.getPath()).append(PATH_SEPARATOR).append(entity.getId());
        return sb.toString();
    }


}
