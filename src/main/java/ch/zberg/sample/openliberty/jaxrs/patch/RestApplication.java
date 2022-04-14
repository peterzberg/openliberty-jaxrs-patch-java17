package ch.zberg.sample.openliberty.jaxrs.patch;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestApplication extends Application {
}
