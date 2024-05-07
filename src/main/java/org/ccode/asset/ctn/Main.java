package org.ccode.asset.ctn;

import org.apache.catalina.startup.Tomcat;


public class Main {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();

        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        tomcat.setPort(Integer.parseInt(webPort));

        tomcat.getConnector();
        tomcat.addWebapp("", new java.io.File("src/main/webapp").getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}