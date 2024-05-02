package org.ccode.asset.ctn.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Api(value = "/ctn/mount", description = "Hello Mount Service")
@Path("/ctn/mount")
public class MountService {

    @GET
    @Path("/{operation}")
    @Produces(MediaType.TEXT_PLAIN)
    @ApiOperation(value = "Mount Operator API", notes = "Mount API Controlling CTN")
    public Response mountOperation(@PathParam("operation") String operation) {
        //Add logic to iterate though an enum/array of mount operations for a positive match
        String output = "Welcome   : " + operation + "\n";
        return Response.ok().entity(output).build();
    }

    @GET
    @Path("/ping")
    public Response ping() {
        //Get feedback from the IRL mount to make sure
        //electricity and mechanical functions are live?
        return Response.ok().entity("Mount service online \n").build();
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotification(@PathParam("id") int id) {
        return Response.ok()
                .entity(new String("{\"" + id + "\":\"test message\"}\n"))
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
