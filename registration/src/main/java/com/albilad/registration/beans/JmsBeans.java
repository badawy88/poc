package com.albilad.registration.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!fake")
public class JmsBeans {
    @Bean
    public SpringJmsConnector connector() {
        SpringJmsConnector connector = new SpringJmsConnector();
        connector.getConfigParameter().put(SpringJmsConnector.ConfigParameters.functionId.name() , "10101010");
        connector.getConfigParameter().put(SpringJmsConnector.ConfigParameters.messageFormat.name() , "Get_National_Address");
        connector.getConfigParameter().put(SpringJmsConnector.ConfigParameters.outputType.name() , "com.bab.common.output");

        return connector;
    }
}
