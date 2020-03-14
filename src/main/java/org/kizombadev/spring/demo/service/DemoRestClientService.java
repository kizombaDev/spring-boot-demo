package org.kizombadev.spring.demo.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kizombadev.spring.demo.configuration.DemoProperties;
import org.kizombadev.spring.demo.configuration.RequestIdStore;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class DemoRestClientService {

    private final RestTemplateBuilder restTemplateBuilder;
    private final DemoProperties demoProperties;

    public String getDemo() {

        log.info("The rest call has the request id {}", RequestIdStore.getRequestId());

        return restTemplateBuilder
                .defaultHeader("Test", RequestIdStore.getRequestId())
                .build()
                .getForEntity(demoProperties.getUrlGet(), String.class)
                .getBody();
    }
}
