package com.muntanji.resources;

import com.muntanji.App;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class WelcomeResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(WelcomeResource.class);
    }

    @Test
    public void checkHomePathWelcomeMessage() {
        Response response = target("/").request().get();
        assertEquals("Response should be plain text", MediaType.TEXT_PLAIN,
                response.getHeaderString(HttpHeaders.CONTENT_TYPE));

        String content = response.readEntity(String.class);
        assertEquals("Invalid welcome message",
                App.configuration.getWelcomeMessage(), content);
    }
}
