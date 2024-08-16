package org.ccode.asset.ctn.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.ccode.asset.ctn.domain.PingResponse;
import org.ccode.asset.ctn.domain.RequestBody;
import org.ccode.asset.ctn.service.OperationService;

import java.time.Instant;

@Path("/ctn/mount")
public class MountService {
    @Inject
    OperationService operationService;


    @GET
    @Path("/{operation}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response mountOperation(@PathParam("operation") String operation,
                                   RequestBody body) {
        operationService.doOperation(operation, body);
        String output = "Welcome   : " + operation + "\n";
        return Response.ok().entity(output)
                .header("X-API-Version", "1.0")
                .header("X-Response-Time", Instant.now().toString())
                .build();
    }

    @GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping() {
        PingResponse response200 = new PingResponse();
        response200.setResponseMessage("Mount service online");
        return Response.ok().entity(response200)
                .header("X-API-Version", "1.0")
                .header("X-Response-Time", Instant.now().toString())
                .build();
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
