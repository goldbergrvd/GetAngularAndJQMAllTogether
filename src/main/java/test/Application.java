package test;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class Application extends ResourceConfig {
    public Application() {
        packages("test.phone");
    }
}
