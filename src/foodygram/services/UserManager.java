package foodygram.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import foodygram.data.IUserStore;
import foodygram.data.DataFactory;
import foodygram.entities.User;

public class UserManager {
	
	// modify this to switch between mock data and mysql
	private final Class<?> userStoreClass = foodygram.data.mock.UserStore.class;
	//private final Class<?> userStoreClass = foodygram.data.UserStore.class;
	
	public UserManager() {
	}
	
	public List<User> GetAllUsers() {
		IUserStore store = DataFactory.CreateUserStore(userStoreClass);
		List<User> users = new ArrayList<User>();
		try {
			 users = store.GetUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public User FindUser(int id) {
		IUserStore store = DataFactory.CreateUserStore(userStoreClass);
		User user = null;
		try {
			user = store.FindUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User AddUser(String firstName, String lastName, String email, String mobileNo) {
		IUserStore store = DataFactory.CreateUserStore(userStoreClass);
		User addedUser = null;
		try {
			User findUserMobile = store.FindByMobileNo(mobileNo);
			User findUserEmail = store.FindByEmail(email);
			
			if (findUserMobile == null && findUserEmail == null) {				
				User user = new User(firstName, lastName, email, mobileNo, new Date());
				addedUser = store.AddUser(user);
			} else {
				throw new Exception("Cannot have duplicate email or mobile");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addedUser;
	}
	
	public List<User> Search(String term) {
		IUserStore store = DataFactory.CreateUserStore(userStoreClass);
		List<User> result = new ArrayList<User>();
		try {
			result = store.Search(term);
		} catch (Exception e) {
			
		}
		return result;
	}
	
	public void UpdateUser(int id, User user) {
		IUserStore store = DataFactory.CreateUserStore(userStoreClass);
		try {
			store.UpdateUser(id, user);
		} catch (Exception e) {
			
		}
	}
	
	public void DeleteUser(int id) {
		IUserStore store = DataFactory.CreateUserStore(userStoreClass);
		try {
			store.DeleteUser(id);
		} catch (Exception e) {
			
		}
	}
}
