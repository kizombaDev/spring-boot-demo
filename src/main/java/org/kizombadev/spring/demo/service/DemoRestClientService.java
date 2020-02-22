package org.kizombadev.spring.demo.service;

import lombok.AllArgsConstructor;
import org.kizombadev.spring.demo.configuration.DemoProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DemoRestClientService {
    private final RestTemplateBuilder restTemplateBuilder;
    private final DemoProperties demoProperties;

    public String getDemo() {
        return restTemplateBuilder.build()
                .getForEntity(demoProperties.getUrlGet(), String.class)
                .getBody();
    }
}
