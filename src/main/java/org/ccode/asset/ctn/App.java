package org.ccode.asset.ctn;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("api")
public class App extends Application {
    // the entry class - deliberately empty in this basic demo
    String serviceId = System.getenv("SERVICE_ID");
}