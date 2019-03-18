package exceptions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Fen
 */
@Provider
public class EntityNotFoundExceptionMapper implements ExceptionMapper<Entity2NotFoundException> {

    @Context
    ServletContext context;
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Response toResponse(Entity2NotFoundException ex) {
//        boolean isDebug = context.getInitParameter("debug").equals("true");
//        ExceptionDTO err = new ExceptionDTO(ex, 404, isDebug);
//        err.setDescription("You tried to call...");

        return Response.status(404)
                .entity(gson.toJson(ex.getDescription()))
                .type(MediaType.APPLICATION_JSON).
                build();
    }
}

