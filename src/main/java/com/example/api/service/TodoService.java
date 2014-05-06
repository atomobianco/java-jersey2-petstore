package com.example.api.service;

import com.example.api.entity.Todo;

import java.util.Collection;

public interface TodoService {

    Collection<Todo> getTodos();

    Todo getById(String id);

    Todo save(Todo todo);

    Todo deleteById(String id);

}
