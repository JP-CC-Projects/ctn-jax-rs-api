package org.ccode.asset.ctn.rest2;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/ctn/mount/park")
public class MountService2 {
    @GET
    @Path("/{name}")
    public Response getMsg(@PathParam("name") String name) {
        String output = "Welcome   : " + name;
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
