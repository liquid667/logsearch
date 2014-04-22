package com.example.backend.resources;

import com.example.backend.model.User;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.server.JSONP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Root resource (exposed at "authenticate" path)
 */
@Path("authenticate")
public class AuthenticationResource {
    private static Logger log = LoggerFactory.getLogger(AuthenticationResource.class);
    

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
    public Response authenticateUser(
            @QueryParam("callback") String callback,
            @QueryParam("username") String username,
            @QueryParam("password") String password) {
        
        String serializedValue = "";
        
        if(!checkInput(username, password)) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{message: 'authentication failure!'}")
                    .build();
        }
        
        ObjectMapper mapper = new ObjectMapper();
        try {
            serializedValue = mapper.writeValueAsString(new User("User123", username, password));
        } catch (IOException ex) {
            log.debug("shit happened, trace: {}", ex);
        }
        
        return Response.ok(serializedValue).build();
    }

    private boolean checkInput(String username, String password) {
        return StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password);
    }
}
