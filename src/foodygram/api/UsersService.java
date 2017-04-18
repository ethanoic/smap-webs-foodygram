package foodygram.api;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import foodygram.services.ManagerFactory;
import foodygram.services.UserManager;
import foodygram.entities.User;

@Path("users")
public class UsersService {
	
	@GET
	@Produces("application/json")
	public Response GetAll() {
		UserManager service = ManagerFactory.CreateUserManager();
		List<User> users = service.GetAllUsers();
		return Response.ok(users).build();
	}
	

	@GET
	@Path("search")
	@Produces("application/json")
	public Response Search(@QueryParam("search") String term) {
		UserManager service = ManagerFactory.CreateUserManager();
		List<User> result = service.Search(term);
		return Response.ok(result).build();
	}
	
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response Get(@PathParam("id") int id) {
		UserManager service = ManagerFactory.CreateUserManager();
		User user = service.FindUser(id);
		return Response.ok(user).build();
	}
	
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response Add(AddUserModel user) {
		UserManager service = ManagerFactory.CreateUserManager();
		User userAdded = service.AddUser(user.FirstName, user.LastName, user.Email, user.MobileNo);
		return Response.ok(userAdded).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes("application/json")
	public Response Update(
			@PathParam("id") int id, 
			User user) {
		UserManager service = ManagerFactory.CreateUserManager();
		service.UpdateUser(id, user);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public Response Delete(
			@PathParam("id") int id
			) {
		UserManager service = ManagerFactory.CreateUserManager();
		service.DeleteUser(id);
		return Response.ok(Status.NO_CONTENT).build();
	}
	
}
