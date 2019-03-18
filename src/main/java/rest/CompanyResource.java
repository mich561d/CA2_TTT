package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.AddressDTO;
import dto.CompanyDTO;
import entity.Company;
import exceptions.Entity2NotFoundException;
import facade.FCityInfo;
import facade.FCompany;
import facade.FPhone;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
 * @author Jesper, Michael
 */
@Path("Company")
public class CompanyResource {

    @Context
    private UriInfo context;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu2", null);
    FCompany fCompany = new FCompany(emf);
    FPhone fPhone = new FPhone(emf);
    FCityInfo fCity = new FCityInfo(emf);

    @GET
    @Path("/Email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyByEmail(@PathParam("email") String email) throws Entity2NotFoundException {
        try {
            return Response.ok().entity(gson.toJson(fCompany.getCompanyByEmail(email))).build();
        } catch (IllegalArgumentException e) {
            throw new Entity2NotFoundException("Company with that email not found.");
        }
    }

    @GET
    @Path("/Phone/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyByPhone(@PathParam("number") String number) throws Entity2NotFoundException {
        try {
            return Response.ok().entity(gson.toJson(fCompany.getCompanyByPhone(fPhone.getPhoneByNumberRaw(number)))).build();
        } catch (IllegalArgumentException e) {
            throw new Entity2NotFoundException("Company with that phone not found.");
        }
    }

    @GET
    @Path("/CVR/{cvr}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyByCVR(@PathParam("cvr") int cvr) throws Entity2NotFoundException {
        try {
            return Response.ok().entity(gson.toJson(fCompany.getCompanyByCVR(cvr))).build();
        } catch (IllegalArgumentException e) {
            throw new Entity2NotFoundException("Company with that CVR not found.");
        }
    }

    @GET
    @Path("/All")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCompanies() {
        return Response.ok().entity(gson.toJson(fCompany.getAllCompanies())).build();
    }

    @GET
    @Path("/City/{zipcode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyByZipCode(@PathParam("zipcode") String number) throws Entity2NotFoundException {
        try {
            return Response.ok().entity(gson.toJson(fCompany.getAllCompaniessByCity(fCity.getCityByZip(number)))).build();
        } catch (IllegalArgumentException e) {
            throw new Entity2NotFoundException("Company with that phone not found.");
        }
    }

    @GET
    @Path("/Address/{address}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyByAddress(@PathParam("address") String address) {
        return Response.ok().entity(gson.toJson(fCompany.getAllCompaniesByAddress(new AddressDTO(0, address, "")))).build();
    }

    @GET
    @Path("/EmployeeCount/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyWithMoreEmployeesThan(@PathParam("amount") int amount) {
        return Response.ok().entity(gson.toJson(fCompany.getAllCompaniesWithNumEmployeesOver(amount))).build();
    }

    @GET
    @Path("/MarketValue/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyWithMoreMarketValueThan(@PathParam("value") int value) {
        return Response.ok().entity(gson.toJson(fCompany.getAllCompaniesWithMarketValueOver(value))).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createHobby(String content) {
        Company c = gson.fromJson(content, Company.class);
        fCompany.createCompany(c);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCompany(String content) {
        CompanyDTO c = gson.fromJson(content, CompanyDTO.class);
        fCompany.updateCompany(c);
    }

    @DELETE
    @Path("/Delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCompany(@PathParam("id") int id) {
        Company c = fCompany.getCompanyByIDRaw(id);
        fCompany.deleteCompany(c.getId());
    }
}
