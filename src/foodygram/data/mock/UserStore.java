package foodygram.data.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import foodygram.data.IUserStore;
import foodygram.entities.User;

public class UserStore implements IUserStore {
	
	private List<User> usersList = new ArrayList();
	private int nextId = 5;
	
	public UserStore() {		
		usersList.add(new User(1, "John", "Wick", "johnwick@local.pc", "88889999", new Date()));
		usersList.add(new User(2, "Luke", "Walker", "lukewaler@local.pc", "7779999", new Date()));
		usersList.add(new User(3, "Jim", "Beat", "jimbeat@local.pc", "81234569", new Date()));
		usersList.add(new User(4, "Rick", "Pat", "rickpat@local.pc", "66789000", new Date()));
	}
	
	@Override
	public User AddUser(User user) throws Exception {
		user.Id = nextId;
		usersList.add(user);
		
		nextId++;
		return user;
	}

	@Override
	public List<User> GetUsers() throws Exception {
		return usersList;
	}

	@Override
	public List<User> Search(String term) throws Exception {
		
		List<User> matchingUsers = new ArrayList<User>();
		for(int i = 0; i < usersList.size(); i++ ) {
			if (usersList.get(i).FirstName.contains(term) || usersList.get(i).LastName.contains(term)) {
				matchingUsers.add(usersList.get(i));
			}
		}
		return matchingUsers;
	}

	@Override
	public User FindUser(int id) throws Exception {
		User user = null;
		
		try {
			user = usersList.stream()
						.filter(t -> t.Id == id)
						.findFirst()
						.get();
		} catch (NoSuchElementException e) {
			
		}
		
		return user;
	}

	@Override
	public void UpdateUser(int id, User user) throws Exception {
		// TODO Auto-generated method stub
		
		usersList.forEach(item->{
			if (item.Id == id) {
				item.Email = user.Email;
				item.FirstName = user.FirstName;
				item.LastName = user.LastName;
				item.MobileNo = user.MobileNo;
			}
		});
	}

	@Override
	public void DeleteUser(int id) throws Exception {
		List<User> users = new ArrayList<User>();
		usersList.forEach(item->{
			if (item.Id == id) {
			} else {
				users.add(item);
			}
		});
		usersList = users;
	}

	@Override
	public User FindByEmail(String email) throws Exception {
		User user = null;
		
		try {
			user = usersList.stream()
						.filter(t -> t.Email == email)
						.findFirst()
						.get();
		} catch (NoSuchElementException e) {
			
		}
		return user;
	}

	@Override
	public User FindByMobileNo(String mobileNo) throws Exception {
		User user = null;
		
		try {
			user = usersList.stream()
						.filter(t -> t.MobileNo == mobileNo)
						.findFirst()
						.get();
		} catch (NoSuchElementException e) {
			
		}
		
		return user;
	}
	
	
	
}
