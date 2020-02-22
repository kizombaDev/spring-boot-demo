package org.kizombadev.spring.demo.controller;

import org.junit.jupiter.api.Test;
import org.kizombadev.spring.demo.service.DemoRestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DemoController.class)
public class DemoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DemoRestClientService demoRestClientService;

    @Test
    public void getDemo() throws Exception {
        final String foo = "foo";

        when(demoRestClientService.getDemo()).thenReturn(foo);

        this.mvc.perform(get("/context/demo"))
                .andExpect(status().isOk())
                .andExpect(content().string(foo));
    }
}