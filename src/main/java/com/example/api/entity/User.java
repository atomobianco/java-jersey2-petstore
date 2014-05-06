package com.example.api.entity;

public class User extends Entity {

    private String username;
    private String givenName; //aka 'first' name in Western countries
    private String surname; //aka 'last' name in Western countries

    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
