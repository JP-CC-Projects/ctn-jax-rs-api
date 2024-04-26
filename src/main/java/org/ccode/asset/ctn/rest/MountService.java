package org.ccode.asset.ctn.rest;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ctn/mount")
public class CameraService {
    @Inject
    private OperationService operationService;


	@GET
	@Path("/")
	public Response mountOperation(@HeaderParam("Operation") String operation) {
        Object parsedOperation = operationService.parseOperation(operation); //Consume incoming header here
        String output = "Welcome   : " + operation;
		return Response.ok().entity(output).build();
	}



    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Mount service online").build();
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotification(@PathParam("id") int id) {
        return Response.ok()
                .entity(new String("{\""+id+ "\":\"test message\"}"))
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
