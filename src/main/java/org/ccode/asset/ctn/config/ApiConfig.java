package org.ccode.asset.ctn.config;
import org.ccode.asset.ctn.service.OperationService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;

import org.glassfish.jersey.server.ResourceConfig;

public class ApiConfig extends ResourceConfig {
    public ApiConfig(){
        register(JacksonFeature.class);
        packages("org.ccode.asset.ctn.rest");
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(OperationService.class).to(OperationService.class);
            }
        });
    }
}
