package org.ccode.asset.ctn.rest2;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.ccode.asset.ctn.service.OperationService;


@Path("/ctn/mount")
public class MountService2 {
    @Inject
    private OperationService operationService;

    @POST
    @Path("/{operation}")
    public Response park(@PathParam("operation") String operation) {
        if (operation == "moveNorth") {
            //move north function
        }
        return Response.ok().entity(operation).build();
    }

    @POST
    @Path("/moveNorth")
    public Response unpark() {
        //move north function
        return Response.status(201).build();
    }

    @GET
    @Path("/")
    public Response mountOperation(@HeaderParam("Operation") String operation) {
        //Add logic to iterate though an enum/array of mount operations for a positive match
        Object parsedOperation = operationService.parseOperation(operation);
        String output = "Welcome   : " + operation;
        return Response.ok().entity(output).build();
    }


    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
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
