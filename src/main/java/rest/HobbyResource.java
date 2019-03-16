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
 * @author Jesper, Michael
 */
@Path("Hobby")
public class HobbyResource {

    @Context
    private UriInfo context;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu2", null);
    FHobby fHobby = new FHobby(emf);

    @GET
    @Path("/Name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHobbyByName(@PathParam("name") String name) {
        return Response.ok().entity(gson.toJson(fHobby.getHobbyByName(name))).build();
    }

    @GET 
    @Path("/All")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllHobbies() {
        return Response.ok().entity(gson.toJson(fHobby.getAllHobbiesRaw())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createHobby(String content) {
        Hobby h = gson.fromJson(content, Hobby.class);
        fHobby.createHobby(h);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateHobby(String content) {
        HobbyDTO h = gson.fromJson(content, HobbyDTO.class);
        fHobby.updateHobby(h);
    }

    @DELETE
    @Path("Delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteHobbyById(@PathParam("id") int id) {
        Hobby h = fHobby.getHobbyByIDRaw(id);
        fHobby.deleteHobbyByID(h.getId());
    }
}
