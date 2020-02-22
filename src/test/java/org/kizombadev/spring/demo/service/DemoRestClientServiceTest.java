package org.kizombadev.spring.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoRestClientServiceTest {

    @Autowired
    private DemoRestClientService underTest;

    @Test
    public void getDemo() {
        underTest.getDemo();
    }
}