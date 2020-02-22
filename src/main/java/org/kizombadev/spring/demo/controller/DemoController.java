package org.kizombadev.spring.demo.controller;

import lombok.AllArgsConstructor;
import org.kizombadev.spring.demo.service.DemoRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "context")
public class DemoController {

    private final DemoRestClientService demoRestClientService;

    @GetMapping(path = "demo")
    public String getDemo() {
        return demoRestClientService.getDemo();
    }
}
