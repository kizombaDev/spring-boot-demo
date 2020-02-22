package org.kizombadev.spring.demo.controller;

import org.junit.jupiter.api.Test;
import org.kizombadev.spring.demo.model.User;
import org.kizombadev.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void getUser() throws Exception {

        given(userService.getUserById(eq(1))).willReturn(new User(1, "Elmo", false));

        this.mvc.perform(get("/demo-service/v1/user/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Elmo"))
                .andExpect(jsonPath("$.active").value(false));
    }
}