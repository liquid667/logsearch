package com.example.backend.resources;

import com.example.backend.model.User;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.apache.commons.lang.StringUtils;
import org.glassfish.jersey.server.JSONP;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("authenticate")
public class AuthenticationResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @param callback
     * @param username
     * @param password
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @JSONP(queryParam = "callback")
    @Produces({"application/x-javascript"})
    public Response authenticateUser(@QueryParam("callback") String callback,
            @QueryParam("username") String username,
            @QueryParam("password") String password) {
        
        if(!checkInput(username, password)) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{message: 'authentication failure!'}")
                    .build();
        }
        return Response.ok(new User("User123", username, password)).build();
    }

    private boolean checkInput(String username, String password) {
        return StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password);
    }
}
