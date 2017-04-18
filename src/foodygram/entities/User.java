package foodygram.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity(name="User")
public class User {
	
	public User() {
		
	}
	
	public User(
			int id,
			String firstName, 
			String lastName,
			String email,
			String mobileNo,
			Date dateJoined) {
		Id = id;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		MobileNo = Email;
		DateJoined = DateJoined;
	}
	
	public User(
			String firstName, 
			String lastName,
			String email,
			String mobileNo,
			Date dateJoined) {
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		MobileNo = Email;
		DateJoined = DateJoined;
	}
	
	@Id
	public int Id;
	
	public String FirstName;
	public String LastName;
	public String Email;
	public String MobileNo;
	public Date DateJoined;
}
