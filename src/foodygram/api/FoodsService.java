package foodygram.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("foods")
public class FoodsService {
	
	@GET
	public Response GetPhotos() {
		
		// TODO
		
		return Response.ok().build();
	}
	
	@POST
	public Response PostPhoto() {
		
		// TODO
		
		return Response.ok().build();
	}
	
	@PUT
	public Response UpdatePhoto() {
		
		// TODO
		
		return Response.ok().build();
	}
	
	@DELETE
	public Response deletePhoto() {
		
		// TODO
		
		return Response.ok().build();
	}

}
