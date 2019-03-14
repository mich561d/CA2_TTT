/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.HobbyDTO;
import entity.Hobby;
import facade.FHobby;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Admin
 */
@Path("hobby")
public class HobbyResource {

    @Context
    private UriInfo context;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu2", null);
    FHobby fHobby = new FHobby(emf);

    /**
     * Creates a new instance of HobbyResource
     */
    public HobbyResource() {
    }

    //Not working (HTTP Status 500)
    @GET
    @Path("/id={id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        return Response.ok().entity(gson.toJson(fHobby.getHobbyByID(id))).build();
    }

    @GET
    @Path("/name={hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getHobbyByName(@PathParam("hobby") String hobby) {
        return Response.ok().entity(gson.toJson(fHobby.getHobbyByName(hobby))).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllHobbies() {
        return Response.ok().entity(gson.toJson(fHobby.getAllHobbies())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void createHobby(String content) {
        Hobby h = gson.fromJson(content, Hobby.class);
        fHobby.createHobby(h);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void updateHobby(String content) {
        HobbyDTO h = gson.fromJson(content, HobbyDTO.class);
        fHobby.updateHobby(h);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteHobbyById(int id) {
        Hobby h = fHobby.getHobbyByID(id);
        fHobby.deleteHobbyByID(h.getId());
    }

//    @DELETE
//    @Produces(MediaType.APPLICATION_JSON)
//    public void deleteHobbyByName(String name) {
//        HobbyDTO h = fHobby.getHobbyByName(name);
//        fHobby.deleteHobbyByName(h.getName());
//    }

}
