package foodygram.services;

import java.util.ArrayList;
import java.util.List;

import foodygram.data.UserStore;
import foodygram.entities.User;

public class UserManager {
	private UserStore store;
	public UserManager() {
		store = new UserStore();
	}
	
	public List<User> GetAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			 users = store.GetUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public User AddUser(User user) {
		User addedUser = null;
		try {
			// TODO, cannot add users with same mobile, email
			
			addedUser = store.AddUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addedUser;
	}
	
	public List<User> Search(String term) {
		List<User> result = new ArrayList<User>();
		try {
			result = store.Search(term);
		} catch (Exception e) {
			
		}
		return result;
	}
}
