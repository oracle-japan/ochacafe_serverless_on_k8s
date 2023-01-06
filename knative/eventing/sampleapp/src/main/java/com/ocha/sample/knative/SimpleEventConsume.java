
package com.ocha.sample.knative;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("/")
public class SimpleEventConsume {

        private static final Logger logger = Logger.getLogger(SimpleEventConsume.class.getName());

        @Path("/")
        @POST
        public Response consume(@Context HttpHeaders httpHeaders,
                        String cloudEventJSON) {
                logger.info("=======New Message Received!!=======");
                logger.info("ce-id=" + httpHeaders.getHeaderString("ce-id"));
                logger.info(
                                "ce-source=" + httpHeaders.getHeaderString("ce-source"));
                logger.info("ce-specversion="
                                + httpHeaders.getHeaderString("ce-specversion"));
                logger.info("ce-time=" + httpHeaders.getHeaderString("ce-time"));
                logger.info("ce-type=" + httpHeaders.getHeaderString("ce-type"));
                logger.info("content-length="
                                + httpHeaders.getHeaderString("content-length"));

                logger.info("POST:" + cloudEventJSON);
                logger.info("=======Message Consumed!!=======");

                return Response.status(Response.Status.OK).entity("{\"Consume Completed!!}")
                                .build();
        }

        @GET
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Path("/")
        public String servingEndpoint() {
                return "{\"hello\":\"world\"}";
        }
}
