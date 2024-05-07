package org.ccode.asset.ctn.config;
import org.glassfish.jersey.jackson.JacksonFeature;

import org.glassfish.jersey.server.ResourceConfig;

public class ApiConfig extends ResourceConfig {
    public ApiConfig(){
        register(JacksonFeature.class);

    }
}
