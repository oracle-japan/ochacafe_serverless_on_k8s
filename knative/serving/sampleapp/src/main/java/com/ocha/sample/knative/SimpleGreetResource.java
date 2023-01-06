
package com.ocha.sample.knative;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/simple-greet")
public class SimpleGreetResource {

    @Path("/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMessage(@PathParam("name") String name) {
        return "Hello!! " + name + " v3";
    }
}
