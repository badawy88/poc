package com.muntanji.config.server;

import com.muntanji.App;
import com.muntanji.annotation.Entity;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Set;

/**
 * System Configuration file
 */
public class JettyServerInitializer {
    /**
     * Application.yaml configuration
     **/
    private static AppConfig configuration;

    private static Logger logger = LoggerFactory.getLogger(JettyServerInitializer.class);

    protected static Tomcat server;

    protected JettyServerInitializer() {
    }

    /**
     * Read Configuration from application.yaml file
     */
    private static void readConfiguration() {
        logger.info("Start reading configuration");
        var properties = new Yaml();
        var inputStream = JettyServerInitializer.class
                .getClassLoader()
                .getResourceAsStream("application.yaml");
        configuration = properties.loadAs(inputStream, AppConfig.class);
        logger.info("End reading configuration");
    }

    /**
     * Initialize server ( port/path/context path and etc... )
     * Most of the configuration from application.yaml file
     */
    protected static AppConfig configServer() {
        readConfiguration();
        logger.info("Start configuring server ...");
        server = new Tomcat();
        server.setPort(configuration.getServerPort());
        try {
            Context context = server.addWebapp("/", new File(".").getAbsolutePath());

            Tomcat.addServlet(context, "Jersey", resourceConfig(configuration));
            context.addServletMapping("/*" , "Jersey");
            logger.info("Server started successfully!");
        } catch (ServletException ex) {
            logger.error("Exception in servlet ", ex);
        }
        return configuration;
    }

    private static ServletContainer resourceConfig( AppConfig appConfig ) {

        System.out.println(appConfig.getJerseyBasePackage());
        Reflections reflections3 = new Reflections("com.muntanji");
        Set<Class<?>> classes = reflections3.getTypesAnnotatedWith(Entity.class);

        //Marshaller marshaller = JAXBContext.newInstance(classes.);
        for(Class c : classes){
            c.asSubclass(App.class);
        }

        System.out.println(classes.size());

        return new ServletContainer(new ResourceConfig(classes));
    }

    protected static void stopServer() throws Exception {
        server.stop();
    }

    protected static void startServer() throws Exception {
        server.start();
        server.getServer().await();
    }
}
