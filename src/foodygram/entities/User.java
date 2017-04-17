package foodygram.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	public int Id;
	
	public String FirstName;
	public String LastName;
	public String Email;
	public String MobileNo;
	public Date DateJoined;
}
