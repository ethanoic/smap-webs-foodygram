package foodygram.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity
@Table(name="foodpictures")
public class FoodPicture {
	@Id
	@GeneratedValue
	public int Id;
	public String Image;
	public Date DateTaken;
	public int UserId;
	public String FoodName;
}
