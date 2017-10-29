package foodygram.app;
import org.glassfish.jersey.server.ResourceConfig;


public class FoodygramApplication  extends ResourceConfig {
    public FoodygramApplication() {
        // Define the package which contains the service classes.
        packages("foodygram.api");
        
        register(MyJacksonFeature.class);
        /*
        //register(BasicAuthenticationFilter.class);
        register(OAuthAuthenticationFilter.class);
        */
    }

}
