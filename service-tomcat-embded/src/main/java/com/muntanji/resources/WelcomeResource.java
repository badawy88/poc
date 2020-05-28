package com.muntanji.resources;

import com.muntanji.App;
import com.muntanji.annotation.Entity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Badawy Abouads
 * @since May 2020
 */
@Path(value = "/")
@Entity
public class WelcomeResource {
    /**
     * Check the status of the service
     * produces plain text
     *
     * @return Welcome message
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String welcome() {
        return App.configuration.getWelcomeMessage();
    }
}
