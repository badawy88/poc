package com.albilad.registration.beans;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Data
public class SpringJmsConnector {
    public enum ConfigParameters {
        codePage("ISO8859_6"),
        functionId(null),
        messageVersion("1.0"),
        messageFormat(null),
        outputType(null),
        command("com.bab.common.commands.xstream.XStreamCommand");
        public String value;

        ConfigParameters(String val) {
            this.value = val;
        }

    }

    private Map<String, String> configParameter = new HashMap();
    private Map<String, String> configParameters = new HashMap<>();

    @NotNull
    private String requestQueueName;
    @NotNull
    private String replayQueueName;

    SpringJmsConnector() {
        Arrays.stream(ConfigParameters.values()).forEach((key) -> configParameter.put(key.name(), key.value));
    }

    @Override
    public String toString() {
        return "SpringJmsConnector{" +
                "configParameter=" + configParameter +
                ", configParameters=" + configParameters +
                ", requestQueueName='" + requestQueueName + '\'' +
                ", replayQueueName='" + replayQueueName + '\'' +
                '}';
    }
}
