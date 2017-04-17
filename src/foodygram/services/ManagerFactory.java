package foodygram.services;

public class ManagerFactory {
	
	private static UserManager userManager;
	private static FoodManager foodManager;
	
	public static UserManager CreateUserManager() {
		if (userManager != null)
			userManager = new UserManager();
		
		return userManager;
	}
	
	public static FoodManager CreateFoodManager() {
		if (foodManager != null)
			foodManager = new FoodManager();
		
		return foodManager;
	}
	
}
