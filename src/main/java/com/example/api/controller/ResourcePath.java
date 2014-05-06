package com.example.api.controller;

import com.example.api.entity.Entity;
import com.example.api.entity.Pet;
import com.example.api.entity.Todo;
import com.example.api.entity.User;

public enum ResourcePath {

    todos(Link.TODOS, Todo.class),
    users(Link.USERS, User.class),
    pets(Link.PETS, Pet.class);

    final String path;
    final Class<? extends Entity> associatedClass;

    private ResourcePath(String elt, Class<? extends Entity> clazz) {
        path = elt;
        associatedClass = clazz;
    }

    public static ResourcePath forClass(Class<? extends Entity> clazz) {
        for (ResourcePath rp : values()) {
            //Cannot use equals because of hibernate proxied object
            //Cannot use instanceof because type not fixed at compile time
            if (rp.associatedClass.isAssignableFrom(clazz)) {
                return rp;
            }
        }
        throw new IllegalArgumentException("No ResourcePath for class '" + clazz.getName() + "'");
    }

    public String getPath() {
        return path;
    }

    public Class<? extends Entity> getAssociatedClass() {
        return associatedClass;
    }
}
