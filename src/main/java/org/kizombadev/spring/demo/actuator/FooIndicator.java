package org.kizombadev.spring.demo.actuator;

import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FooIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().build();
    }
}
