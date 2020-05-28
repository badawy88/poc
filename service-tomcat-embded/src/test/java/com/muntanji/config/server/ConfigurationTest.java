package com.muntanji.config.server;

import static org.junit.Assert.*;

import com.muntanji.App;
import org.junit.Test;

public class ConfigurationTest {

    @Test
    public void configurationTest() {
        AppConfig configuration = App.configuration;
        assertNotNull(configuration);
        assertEquals("Port should be 8090", 8090, configuration.getServerPort());
        assertEquals("Base package should be com.muntanji.resources", "com.muntanji.resources", configuration.getJerseyBasePackage());
        assertEquals("Context path should be /", "/", configuration.getServerContextPath());
        assertEquals("Server path spec should be /*", "/*", configuration.getServerPathSpec());
    }
}
