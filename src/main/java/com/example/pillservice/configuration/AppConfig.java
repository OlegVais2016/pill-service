package com.example.pillservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "ps.core")
@Configuration
@Getter
@Setter
public class AppConfig {

    private String registrationConformationUrl;


}
