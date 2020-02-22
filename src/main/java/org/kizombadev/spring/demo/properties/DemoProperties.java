package org.kizombadev.spring.demo.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {
    private String urlGet;
    private String urlPost;
}
