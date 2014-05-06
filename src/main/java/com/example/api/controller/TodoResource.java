package com.example.api.controller;

import com.example.api.entity.Todo;

import javax.ws.rs.core.UriInfo;

@SuppressWarnings("unchecked")
public class TodoResource extends Link {

    public TodoResource(UriInfo info, Todo todo) {
        super(info, todo);
        put("name", todo.getName());
        put("done", todo.isDone());
        put("created", todo.getCreated());
        put("user", new Link(getFullyQualifiedContextPath(info), todo.getUser()));
    }
}
