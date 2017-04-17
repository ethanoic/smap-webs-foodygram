package foodygram.api;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("users")
public class User {
	
	@GET
	public Response GetAll() {
		
		return Response.ok().build();
	}
	
	@GET
	@Path("users/{id}")
	public Response Get(@PathParam(value = "") int id) {
		return Response.ok().build();
	}
	
	@POST
	public Response Add() {
		return Response.ok().build();
	}
	
	@PUT
	public Response Update() {
		return Response.ok().build();
	}
	
	@DELETE
	public Response Delete() {
		return Response.ok().build();
	}
}
