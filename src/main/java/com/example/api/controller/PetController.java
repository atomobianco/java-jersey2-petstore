package com.example.api.controller;

import com.example.api.entity.Pet;
import com.example.api.service.DefaultPetService;
import com.example.api.service.PetService;
import com.wordnik.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Path(Link.PETS)
@Api(value = "/pets", description = "Operations about pets")
@Produces({"application/json"})
@Consumes({"application/json"})
public class PetController extends BaseController {

    private PetService petService = DefaultPetService.getInstance();

    @ApiOperation(value = "Find all pets", response = CollectionResource.class)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CollectionResource getPets(@Context UriInfo info) {
        Collection<Pet> pets = petService.getPets();
        if (pets == null || pets.size() == 0) {
            return new CollectionResource(info, Link.PETS, Collections.emptyList());
        }
        Collection items = new ArrayList(pets.size());
        for( Pet pet : pets ) {
            items.add(new Link(info, pet));
        }
        return new CollectionResource(info, Link.PETS, items);
    }

    @ApiOperation(value = "Find pet by ID", response = PetResource.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied"), @ApiResponse(code = 404, message = "Pet not found") })
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PetResource getPet(@Context UriInfo info, @ApiParam(value = "ID of pet that needs to be fetched", required = true) @PathParam("id") String id) {
        Pet pet = petService.getById(id);
        if (pet == null) {
            throw new UnknownResourceException();
        }
        return new PetResource(info, pet);
    }

    @ApiOperation(value = "Add a new pet to the store", response = PetResource.class)
    @ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input") })
    @ApiImplicitParams({@ApiImplicitParam(name = "body", value = "Pet object that needs to be created in the store", required = true, dataType = "PetResource", paramType = "body")})
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPet(@Context UriInfo info, @ApiParam(access = "internal") Pet pet) {
        pet = petService.save(pet);
        PetResource resource = new PetResource(info, pet);
        return created(resource);
    }
}
