package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facade.FCityInfo;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Jesper, Michael
 */
@Path("City")
public class CityInfoResource {

    @Context
    private UriInfo context;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu2", null);
    FCityInfo fCity = new FCityInfo(emf);

    @GET
    @Path("/AllCities")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCities() {
        return Response.ok().entity(gson.toJson(fCity.getAllCities())).build();
    }

    @GET
    @Path("/{zip}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCityByZip(@PathParam("zip") String zip) {
        return Response.ok().entity(gson.toJson(fCity.getCityByZip(zip))).build();
    }

    @GET
    @Path("/AllZips")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.ok().entity(gson.toJson(fCity.getAllZipCodes())).build();
    }
}
