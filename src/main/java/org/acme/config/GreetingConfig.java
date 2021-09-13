package org.acme.config;

import io.quarkus.arc.config.ConfigProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@ConfigProperties(prefix = "greeting")
@Data
public class GreetingConfig {
    private Optional<Integer> number;
    private String prefix;
    private String suffix = "!";
    private String name;
    private Country country;

    @Data
    @NoArgsConstructor
    public static class Country {
        String name;
        Integer id;
    }
    
}


