package org.hoestschaamte.corona.config;

import org.hoestschaamte.corona.resources.ReserveringResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/resources")
public class JaxRSConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(ReserveringResource.class);
        return classes;
    }
}
