package com.example.api.entity;

/**
 * Base class for all persistent entities in the application.
 */
public abstract class Entity {

    private String id;

    public Entity(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
