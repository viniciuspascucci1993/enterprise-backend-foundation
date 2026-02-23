package com.enterprise.foundation.config;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class InfoConfig {

    @Bean
    public InfoContributor platformInfoContributor() {
        return builder -> builder.withDetail("platform",
                Map.of(
                        "name", "Enterprise Backend Foundation",
                        "version", "0.0.2",
                        "environment", "local"
                )
        );
    }
}