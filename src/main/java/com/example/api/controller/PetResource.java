package com.example.api.controller;

import com.example.api.entity.Pet;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.ws.rs.core.UriInfo;
import java.util.LinkedHashMap;

@ApiModel(value = "Pet", description = "Pet resource", parent = LinkedHashMap.class)
public class PetResource extends Link {

    @ApiModelProperty(value = "Pet name") public String getName() { return (String) get("name"); }
    @ApiModelProperty(value = "Pet URL")  public String getHref() { return (String) get("href"); }

    public PetResource(UriInfo info, Pet pet) {
        super(info, pet);
        put("name", pet.getName());
        if (pet.getCategory() != null) put("category", new Link(getFullyQualifiedContextPath(info), pet.getCategory()));
    }
}
