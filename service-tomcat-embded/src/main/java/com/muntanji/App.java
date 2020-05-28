package com.muntanji;

import com.muntanji.config.server.AppConfig;
import com.muntanji.config.server.JettyServerInitializer;
import org.apache.catalina.startup.Tomcat;
//import org.eclipse.jetty.server.Server;

/**
 * Hello world!
 */
public class App extends JettyServerInitializer {
    public static final AppConfig configuration = configServer();
    public static final Tomcat appServer = server;

    public App() throws Exception {
        startAppServer();
    }

    public static void main(String[] args) throws Exception {
        new App();
    }

    public static void startAppServer() throws Exception {
        startServer();
    }

    public static void stopAppServer() throws Exception {
        stopServer();
    }
}
