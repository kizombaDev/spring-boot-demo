package org.kizombadev.spring.demo.actuator;

import lombok.AllArgsConstructor;
import org.kizombadev.spring.demo.configuration.RequestIdStore;
import org.kizombadev.spring.demo.service.DemoRestClientService;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class DemoRestClientIndicator implements HealthIndicator {

    private final DemoRestClientService demoRestClientService;

    @Override
    public Health health() {
        try {
            RequestIdStore.setRequestId(UUID.randomUUID().toString());
            demoRestClientService.getDemo();
        } catch (Exception e) {
            return Health.down().build();
        }
        return Health.up().build();
    }
}
