package foodygram.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import foodygram.entities.User;

public class UserStore {
	private Configuration cfg;
	private SessionFactory factory;
	private Session session;
	
	public UserStore() {
		cfg = new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	      
	    //creating seession factory object  
	    factory = cfg.buildSessionFactory();
	}
	
	public User AddUser(User user) throws Exception {
	    User newUser = new User();
	    
		try {
			//creating session object  
		    session = factory.openSession();  
		      
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
	
	public List<User> GetUsers() throws Exception {
		List<User> users = new ArrayList<User>();
		try {
			session = factory.openSession();
			
			Query<User> query = session.createQuery("from User");
			users = query.list();
			
			session.close();
		} catch (Exception ex) {
			
		}
		return users;
	}
	
	public List<User> Search(String term) throws Exception {

		List<User> users = new ArrayList<User>();
		try {
			session = factory.openSession();
			
			Query<User> query = session.createQuery("from User where FirstName like :f OR LastName like :l");
			query.setParameter("f", term);
			query.setParameter("l", term);
			
			users = query.list();
			
			session.close();
		} catch (Exception ex) {
			
		}
		return users;
	}
}
