package foodygram.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import foodygram.entities.User;

public class UserStore implements IUserStore {
	private Session session;
	
	public UserStore() {
		
	}
	
	@Override
	public User AddUser(User user) throws Exception {
	    User newUser = new User();
	    
		try {
			//creating session object  
		    session = HibernateUtil.getSessionFactory().openSession();  
		      
		    //creating transaction object  
		    Transaction t=session.beginTransaction();
		    
		    newUser.DateJoined = user.DateJoined;
		    newUser.Email = user.Email;
		    newUser.FirstName = user.FirstName;
		    newUser.LastName = user.LastName;
		    newUser.MobileNo = user.MobileNo;
		    
		    session.persist(newUser);//persisting the object  
		      
		    t.commit();//transaction is committed
		    
		    session.close();  
		} catch (Exception ex) {
			
		}
		
		return newUser;
	}
	
	@Override
	public List<User> GetUsers() throws Exception {
		List<User> users = new ArrayList<User>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();  
			
			Query<User> query = session.createQuery("from User");
			users = query.list();
			
			session.close();
		} catch (Exception ex) {
			
		}
		return users;
	}
	
	@Override
	public List<User> Search(String term) throws Exception {

		List<User> users = new ArrayList<User>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();  
			
			Query<User> query = session.createQuery("from User where FirstName like :f OR LastName like :l");
			query.setParameter("f", term);
			query.setParameter("l", term);
			
			users = query.list();
			
			session.close();
		} catch (Exception ex) {
			
		}
		return users;
	}
	
	@Override
	public User FindUser(int id) throws Exception {

		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();  
			
			Query<User> query = session.createQuery("from User where Id = :id");
			query.setParameter("id", id);
			
			user = query.getSingleResult();
			
			session.close();
		} catch (Exception ex) {
			
		}
		return user;
	}

	@Override
	public void UpdateUser(int id, User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User FindByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User FindByMobileNo(String mobileNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
