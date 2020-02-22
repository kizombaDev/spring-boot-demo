package org.kizombadev.spring.demo.actuator;

import lombok.AllArgsConstructor;
import org.kizombadev.spring.demo.service.DemoRestClientService;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DemoRestClientIndicator implements HealthIndicator {

    private final DemoRestClientService demoRestClientService;

    @Override
    public Health health() {
        try {
            demoRestClientService.getDemo();
        } catch (Exception e) {
            return Health.down().build();
        }
        return Health.up().build();
    }
}
