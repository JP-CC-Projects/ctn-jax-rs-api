package org.ccode.asset.ctn.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.ccode.asset.ctn.domain.ResponseMessage;

@Path("/ctn/mount")
public class MountService {

    @GET
    @Path("/{operation}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response mountOperation(@PathParam("operation") String operation) {
        //Add logic to iterate though an enum/array of mount operations for a positive match
        String output = "Welcome   : " + operation + "\n";
        return Response.ok().entity(output).build();
    }

    @GET
    @Path("/ping")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping() {
        ResponseMessage response200 = new ResponseMessage();
        response200.setResponseMessage("Mount service online");
        return Response.ok().entity(response200).build();
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
