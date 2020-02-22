package org.kizombadev.spring.demo.actuator;

import org.junit.jupiter.api.Test;
import org.kizombadev.spring.demo.service.DemoRestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class DemoRestClientIndicatorTest {

    @Autowired
    private DemoRestClientIndicator underTest;

    @MockBean
    private DemoRestClientService demoRestClientService;

    @Test
    public void healthUp() {
        when(demoRestClientService.getDemo()).thenReturn("foo");

        Health health = underTest.health();

        assertEquals(Status.UP, health.getStatus());
    }

    @Test
    public void healthDown() {
        when(demoRestClientService.getDemo()).thenThrow(new IllegalStateException());

        Health health = underTest.health();

        assertEquals(Status.DOWN, health.getStatus());
    }
}