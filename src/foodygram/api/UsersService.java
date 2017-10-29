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

/*
 * UsersService class handles all rest calls that match the path '/api/users' 
 * the prefix 'api' is defined in this project WebContent/WEB-INF/web.xml under servlet-mapping
 * as defined in the annotation @Path("users")
 * This java class handles the requests and responses for this resource 'users'
 */
@Path("users")
public class UsersService {
	
	/*
	 * GET /api/users
	 * This method returns all users from the data storage
	 */
	@GET
	@Produces("application/json")
	public Response GetAll() {
		/*
		 *  This is what we call a factory pattern implementation - a class is used to
		 *  return another class that is constantly used in the application 
		 */
		UserManager service = ManagerFactory.CreateUserManager();
		List<User> users = service.GetAllUsers();
		return Response.ok(users).build();
	}
	
	/*
	 * GET /api/users/search?search={name}
	 * This method returns a result of a search - this method does not contain 
	 * the logic for searching is written in the UserManager class
	 * The parameter here passed via the web service url is called a query parameter,
	 * 	which begins with '?' and followed by key value pairs where key=value&key2=value2
	 * The method parameter 'term' takes the value from the key 'search' from the query parameters 
	 */
	@GET
	@Path("search")
	@Produces("application/json")
	public Response Search(@QueryParam("search") String term) {
		UserManager service = ManagerFactory.CreateUserManager();
		List<User> result = service.Search(term);
		return Response.ok(result).build();
	}
	
	/*
	 * GET /api/users/{id}
	 * This method retrieves a user by referring to the {id} parameter in the request
	 * the {id} is a path parameter that allows parameters to be passed into this web service
	 * The method parameter id is mapped to the path parameter @Path("{id}") 
	 * 	using the method parameter annotation @PathParam("id")
	 * To define path parameters in the @Path - we must encapsulate the parameter name with { and }
	 * The actual method parameter name does not need to be the same as the path parameter name therefore
	 * 	Response Get(@PathParam("id") int user_id) will get the same value as Response Get(@PathParam("id") int id)  
	 */
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response Get(@PathParam("id") int id) {
		UserManager service = ManagerFactory.CreateUserManager();
		User user = service.FindUser(id);
		return Response.ok(user).build();
	}
	
	/*
	 * POST /api/users
	 * This method adds a user to the resource 'users'
	 * The parameter here is an object represented with json, therefore @Consumes("application/json")
	 * If the parameter here can be accepted as an xml - it will have a different data anotation @Consumes("application/xml")
	 * Java Jersey automatically maps the request body (json raw) to the parameter here
	 * The name of the parameter that is the expected request body does not matter
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response Add(AddUserModel user) {
		UserManager service = ManagerFactory.CreateUserManager();
		User userAdded = service.AddUser(user.FirstName, user.LastName, user.Email, user.MobileNo);
		return Response.ok(userAdded).build();
	}
	
	/*
	 * PUT /api/users/{id}
	 * This method updates an existing user by referencing the user to be replaced/updated via the {id}
	 * The path parameter {id} here refers to the id or identity of the user in the database
	 * The other parameter here is the 'User' object which is represented with json (@Consumes("application/json")
	 * Java Jersery here automatically matches the parameter 'User' as an expected request body
	 */
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
	
	/*
	 * DELETE /api/users/{id}
	 * This method deletes a user with the id {id} specified in the path parameter
	 */
	@DELETE
	@Path("{id}")
	public Response Delete(
			@PathParam("id") int id
			) {
		UserManager service = ManagerFactory.CreateUserManager();
		service.DeleteUser(id);
		return Response.ok().build();
	}
	
}
