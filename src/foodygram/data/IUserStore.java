package foodygram.data;

import java.util.List;

import foodygram.entities.User;

public interface IUserStore {
	public User AddUser(User user) throws Exception;
	public List<User> GetUsers() throws Exception;
	public List<User> Search(String term) throws Exception;
	public User FindUser(int id) throws Exception;
	public void UpdateUser(int id, User user) throws Exception;
	public void DeleteUser(int id) throws Exception;
	public User FindByEmail(String email) throws Exception;
	public User FindByMobileNo(String mobileNo) throws Exception;
}
