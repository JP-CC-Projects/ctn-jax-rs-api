package org.ccode.asset.ctn;
import org.apache.catalina.startup.Tomcat;
public class Main {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        System.out.println("The Main class is running - 1");
        System.out.println("The Main class is running - 2");
        System.out.println("The Main class is running - 3");
        System.out.println("The Main class is running - 4");
        System.out.println("The Main class is running - 5");


        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        System.out.println("ABC: " + webPort);

        tomcat.setPort(Integer.parseInt(webPort));

        tomcat.getConnector();
        tomcat.addWebapp("", new java.io.File("src/main/webapp").getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}