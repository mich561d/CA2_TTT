package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facade.FCompany;
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
 * @author Jesper
 */
@Path("company")
public class CompanyResource {

    @Context
    private UriInfo context;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    EntityManagerFactory emf;
    FCompany fCompany = new FCompany(emf);
    FPhone fPhone = new FPhone(emf);
    Facade f = new Facade();

    /**
     * Creates a new instance of CompanyResource
     */
    public CompanyResource() {
    }

    @GET
    @Path("/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCompanyByPhone(@PathParam("number") String number) {
        return Response.ok().entity(gson.toJson(fCompany.getCompanyByPhone(fPhone.getPhoneByNumber(number)))).build();
    }

    @GET
    @Path("/{cvr}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCompanyByCVR(@PathParam("cvr") int cvr) {
        return Response.ok().entity(gson.toJson(fCompany.getCompanyByCVR(cvr))).build();
    }
    
    

}
