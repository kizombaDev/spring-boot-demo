package org.kizombadev.spring.demo.controller;

import lombok.AllArgsConstructor;
import org.kizombadev.spring.demo.service.DemoRestClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class DemoController implements DemoApi {

    private final DemoRestClientService demoRestClientService;

    @Override
    public ResponseEntity<String> demoCall() {
        return ResponseEntity.ok(demoRestClientService.getDemo());
    }
}
