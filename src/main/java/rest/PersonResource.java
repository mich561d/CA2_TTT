/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facade.FPerson;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
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
@Path("person")
public class PersonResource {

    @Context
    private UriInfo context;
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    EntityManagerFactory emf;
    FPerson fPerson = new FPerson(emf);
    FPhone

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
    }

    /**
     * Retrieves representation of an instance of rest.PersonResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPersonByPhone(@PathParam("number") String number) {
        return Response.ok().entity(gson.toJson(f.getPersonByPhone(f.getPhoneByNumber(number)))).build();

    }

    /**
     * PUT method for updating or creating an instance of PersonResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
