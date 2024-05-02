package org.ccode.asset.ctn.config;

import io.swagger.jaxrs.config.BeanConfig;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import java.util.logging.Logger;

public class SwaggerConfiguration extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(SwaggerConfiguration.class.getName());

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        LOGGER.info("Initializing Swagger Configuration");
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("org.ccode.asset.ctn.rest");
        beanConfig.setScan(true);
        LOGGER.info("Swagger Configuration initialized: " + beanConfig.toString());
    }
}
