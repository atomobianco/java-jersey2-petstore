package com.example.api.service;

import com.example.api.entity.Pet;
import com.example.api.entity.User;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultPetService implements PetService {

    //ordinarily this would be a DAO used to interact with a data store (e.g. database or NoSQL store).
    Map<String,Pet> pets = new ConcurrentHashMap<String, Pet>();

    //ordinarily DependencyInjection would be used.  This simple example just uses a static singleton:
    private static final DefaultPetService INSTANCE = new DefaultPetService();

    //simulate a single User for the demo:
    private final User user;

    public DefaultPetService() {
        //simulate a single User for this demo:
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setUsername("jsmith");
        user.setGivenName("John");
        user.setSurname("Smith");
        this.user = user;
    }

    @Override
    public Collection<Pet> getPets() {
        return pets.values();
    }

    @Override
    public Pet getById(String id) {
        return pets.get(id);
    }

    @Override
    public Pet save(Pet pet) {
        String id = pet.getId();
        if (id == null) {
            //create:
            id = UUID.randomUUID().toString().replace("-","");
            pet.setId(id);

            pets.put(id, pet);

        } else {
            //update:
            pets.put(id, pet);
        }

        return pet;
    }

    protected User getCurrentUser() {
        //return the 'current user' based on a security framework like Shiro.
        //For this demo, we'll just assume a simulated/manually-constructed one:
        return this.user;
    }

    @Override
    public Pet deleteById(String id) {
        return pets.remove(id);
    }

    public static PetService getInstance() {
        return INSTANCE;
    }
}
