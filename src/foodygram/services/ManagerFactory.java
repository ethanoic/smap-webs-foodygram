package foodygram.services;

public class ManagerFactory {
	private static final ManagerFactory INSTANCE = new ManagerFactory();

	private ManagerFactory(){}

	public static ManagerFactory getInstance(){
      return INSTANCE;
	}
	
	private static UserManager userManager;
	private static FoodManager foodManager;
	
	public static UserManager CreateUserManager() {
		if (userManager == null)
			userManager = new UserManager();
		
		return userManager;
	}
	
	public static FoodManager CreateFoodManager() {
		if (foodManager == null)
			foodManager = new FoodManager();
		
		return foodManager;
	}
	
}
