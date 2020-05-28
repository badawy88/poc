package com.muntanji.config.server;

import com.muntanji.annotation.Entity;
import lombok.Getter;
import lombok.Setter;

public class AppConfig {
    /**
     * server port
     **/
    @Setter
    @Getter
    private int serverPort;
    /**
     * server path spec
     **/
    @Setter
    @Getter
    private String serverPathSpec;
    /**
     * server context path
     **/
    @Setter
    @Getter
    private String serverContextPath;
    /**
     * Default welcome message
     **/
    @Setter
    @Getter
    private String welcomeMessage;
    @Setter
    @Getter
    private String jerseyBasePackage;
}
