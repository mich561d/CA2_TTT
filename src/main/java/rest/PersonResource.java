package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facade.FPerson;
import facade.FPhone;
import facade.Facade;
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
    FPhone fPhone = new FPhone(emf);
    Facade f = new Facade();

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
    }

    /**
     * Retrieves representation of an instance of rest.PersonResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPersonByPhone(@PathParam("number") String number) {
        return Response.ok().entity(gson.toJson(fPerson.getPersonByPhone(fPhone.getPhoneByNumber(number)))).build();

    }
    
    @GET
    @Path("/person/{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPersonsByHobby(@PathParam("hobby") String hobby) {
        return Response.ok().entity(gson.toJson(f.getAllPersonsByHobby(f.getHobbyByName(hobby)))).build();
    }

    @GET
    @Path("/person/{zipcode}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllPersonsByCity(@PathParam("zipcode") String zipcode) {
        return Response.ok().entity(gson.toJson(f.getAllPersonsByCity(f.getCityByZip(zipcode)))).build();
    }
}
