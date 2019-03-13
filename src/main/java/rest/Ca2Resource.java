/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facade.Facade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Jesper
 */
@Path("ca2")
public class Ca2Resource {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Facade f = new Facade();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Ca2Resource
     */
    public Ca2Resource() {
    }

    @GET
    @Path("/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPhoneByNumber(@PathParam("number") String number) {
        return Response.ok().entity(gson.toJson(f.getPhoneByNumber(number))).build();
    }

    @GET
    @Path("/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPersonByPhone(@PathParam("number") String number) {
        //return Response.ok().entity(gson.toJson(f.getPersonByPhone())).build();
        return null;
    }

    @GET
    @Path("/{cvr}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCompanyByCVR(@PathParam("cvr") int cvr) {
        return Response.ok().entity(gson.toJson(f.getCompanyByCVR(cvr))).build();
    }

    @GET
    @Path("/{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getHobbyByName(@PathParam("hobby") String hobby) {
        return Response.ok().entity(gson.toJson(f.getHobbyByName(hobby))).build();
    }

    @GET
    @Path("/{zip}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCityByZip(@PathParam("zip") String zip) {
        return Response.ok().entity(gson.toJson(f.getCityByZip(zip))).build();
    }

    @GET
    @Path("/all/zipcodes")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllZipCodes() {
        return Response.ok().entity(gson.toJson(f.getAllZipCodes())).build();
    }

    @GET
    @Path("/company/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCompanyWithMoreEmployeesThan(@PathParam("amount") int amount) {
        return Response.ok().entity(gson.toJson(f.getAllCompaniesWithMoreEmployeesThan(amount))).build();
    }

}
