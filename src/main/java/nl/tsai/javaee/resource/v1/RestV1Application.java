package nl.tsai.javaee.resource.v1;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.Set;

@ApplicationPath("/api/v1")
public class RestV1Application extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Collections.singleton(HelloV1Resource.class);
    }
}