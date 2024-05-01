package org.ccode.asset.ctn.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.ccode.asset.ctn.service.OperationService;

@Api
@Path("/ctn/mount")
public class MountService {

    @GET
    @Path("/")
    public Response mountOperation(@HeaderParam("Operation") String operation) {
        //Add logic to iterate though an enum/array of mount operations for a positive match
        String output = "Welcome   : " + operation;
        return Response.ok().entity(output).build();
    }

    @GET
    @Path("/ping")
    public Response ping() {
        //Get feedback from the IRL mount to make sure
        //electricity and mechanical functions are live?
        return Response.ok().entity("Mount service online").build();
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotification(@PathParam("id") int id) {
        return Response.ok()
                .entity(new String("{\"" + id + "\":\"test message\"}"))
                .build();
    }

    @POST
    @Path("/post/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postNotification(String notification) {
        return Response.status(201).entity(notification).build();
    }
}
