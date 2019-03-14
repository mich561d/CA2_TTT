package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.PersonDTO;
import entity.Person;
import facade.FCityInfo;
import facade.FHobby;
import facade.FPerson;
import facade.FPhone;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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
    FPhone fPhone = new FPhone(emf);
    FHobby fHobby = new FHobby(emf);
    FCityInfo fCity = new FCityInfo(emf);

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
    }

    @GET
    @Path("/id={id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        return Response.ok().entity(gson.toJson(fPerson.getPersonByID(id))).build();
    }

//    @GET
//    @Path("/Person/email={email}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response getPersonByEmail(@PathParam("email") String email) {
//        return Response.ok().entity(gson.toJson(fPerson.getPersonByEmail(email))).build();
//    }
//
//    @GET
//    @Path("/Person/phone={number}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response getPersonByPhone(@PathParam("number") String number) {
//        return Response.ok().entity(gson.toJson(fPerson.getPersonByPhone(fPhone.getPhoneByNumber(number)))).build();
//
//    }
//
//    @GET
//    @Path("/Person/all")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response getAllPersons(@PathParam("number") String number) {
//        return Response.ok().entity(gson.toJson(fPerson.getAllPersons())).build();
//    }
//
//    @GET
//    @Path("/person/hobby={hobby}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response getPersonsByHobby(@PathParam("hobby") String hobby) {
//        return Response.ok().entity(gson.toJson(fPerson.getAllPersonsByHobby(fHobby.getHobbyByName(hobby)))).build();
//    }
//
//    @GET
//    @Path("/person/zipcode={zipcode}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response getAllPersonsByCity(@PathParam("zipcode") String zipcode) {
//        return Response.ok().entity(gson.toJson(fPerson.getAllPersonsByCity(fCity.getCityByZip(zipcode)))).build();
//    }
//
//    @GET
//    @Path("/Person/address={address}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response getAllPersonsByAddress(@PathParam("address") String address) {
//        return null;
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void createPerson(String content) {
//        Person p = gson.fromJson(content, Person.class);
//        fPerson.createPerson(p);
//    }
//
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void updatePerson(String content) {
//        PersonDTO p = gson.fromJson(content, PersonDTO.class);
//        fPerson.updatePerson(p);
//    }
//
//    @DELETE
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void deletePerson(int id) {
//        fPerson.deletePersonById(fPerson.getPersonByID(id).getId());
//    }

    //    @GET
//    @Path("/person/{zipcode}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response getAllPersonsByCity(@PathParam("zipcode") String zipcode) {
//        return Response.ok().entity(gson.toJson(f.getAllPersonsByCity(f.getCityByZip(zipcode)))).build();
//    }
}
