package com.example.api.controller;

import com.example.api.entity.Pet;

import javax.ws.rs.core.UriInfo;

public class PetResource extends Link {

    public PetResource(UriInfo info, Pet pet) {
        super(info, pet);
        put("name", pet.getName());
        if (pet.getCategory() != null) put("category", new Link(getFullyQualifiedContextPath(info), pet.getCategory()));
    }
}
