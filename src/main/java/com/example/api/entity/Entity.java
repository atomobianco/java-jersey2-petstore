package com.example.api.entity;

/**
 * Base class for all persistent entities in the application.
 */
public abstract class Entity {

    private String id;
    private String type;

    /* Constructors */
    public Entity(){}

    /* Getters */
    public String   getId() { return id; }
    public String   getType() { return type; }

    /* Setters */
    public void     setId(String id) { this.id = id; }
    public void     setType(String type) { this.type = type; }
}
