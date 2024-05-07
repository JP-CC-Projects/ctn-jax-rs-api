package org.ccode.asset.ctn;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();

        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }


        tomcat.setPort(Integer.parseInt(webPort));
        tomcat.getConnector();
        tomcat.setBaseDir("temp");

        String webappDirLocation = "src/main/webapp/";
        tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());
        tomcat.start();
        tomcat.getServer().await();
    }
}