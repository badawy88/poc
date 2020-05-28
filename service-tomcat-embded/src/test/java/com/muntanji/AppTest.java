package com.muntanji;


import static org.junit.Assert.*;

import org.apache.catalina.startup.Tomcat;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testMain() throws Exception {
        App.main(null);
        Tomcat appServer = App.appServer;
//        assertTrue(appServer.isStarted());
//
//        int serverPort = ((ServerConnector) (appServer.getConnectors()[0])).getLocalPort();
//        assertEquals("", App.configuration.getServerPort(), serverPort);
//
//        App.stopAppServer();
//        assertTrue(appServer.isStopped());
    }
}
