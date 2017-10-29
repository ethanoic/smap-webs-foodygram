package foodygram.data;

public class DataFactory {
	private static IUserStore userStore;

	public static IUserStore CreateUserStore(Class<?> storeType) {	
		if (userStore == null) {
			if (storeType == foodygram.data.mock.UserStore.class)
				userStore = new foodygram.data.mock.UserStore();
			/*
			if (storeType == foodygram.data.UserStore.class)
				userStore = new foodygram.data.UserStore();
			*/
		}
		
		return userStore;
	}
	
}
