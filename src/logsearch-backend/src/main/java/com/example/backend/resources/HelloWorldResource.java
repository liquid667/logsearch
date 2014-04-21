package com.example.backend.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.glassfish.jersey.server.JSONP;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("helloworld")
public class HelloWorldResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @param callback
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @JSONP(queryParam = "callback")
    @Produces({"application/x-javascript"})
    public String helloWorld(@QueryParam("callback") String callback) {
        return "{message: 'Hello cruel world!'}";   
    }
}
