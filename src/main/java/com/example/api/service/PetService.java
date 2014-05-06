package com.example.api.service;

import com.example.api.entity.Pet;

import java.util.Collection;

public interface PetService {

    Collection<Pet> getPets();

    Pet getById(String id);

    Pet save(Pet pet);

    Pet deleteById(String id);

}
