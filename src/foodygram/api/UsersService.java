package foodygram.api;

import java.util.*;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import foodygram.services.ManagerFactory;
import foodygram.services.UserManager;
import foodygram.entities.User;

@Path("users")
public class UsersService {
	private UserManager service;
	/*
	public UsersService() {
		service = ManagerFactory.CreateUserManager();
	}
	*/
	@GET
	public Response GetAll() {
		List<User> users = service.GetAllUsers();
		return Response.ok(users).build();
	}
	
	@GET
	@Path("users/search")
	public Response Search(@QueryParam(value = "") String term) {
		List<User> result = service.Search(term);
		return Response.ok(result).build();
	}
	
	@GET
	@Path("users/{id}")
	public Response Get(@PathParam(value = "") int id) {
		return Response.ok().build();
	}
	
	@POST
	public Response Add(User user) {
		User userAdded = service.AddUser(user);
		return Response.ok(userAdded).build();
	}
	
	@PUT
	@Path("users/{id}")
	public Response Update(User user) {
		return Response.ok().build();
	}
	
	@DELETE
	@Path("users/{id}")
	public Response Delete() {
		return Response.ok(Status.NO_CONTENT).build();
	}
}
