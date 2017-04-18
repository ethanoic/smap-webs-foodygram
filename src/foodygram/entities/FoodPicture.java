package foodygram.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity(name="FoodPicture")
public class FoodPicture {
	
	public FoodPicture() {
		
	}
	
	@Id
	public int Id;
	public String Image;
	public Date DateTaken;
	public int UserId;
	public String FoodName;
}
