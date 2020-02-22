package org.kizombadev.spring.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kizombadev.spring.demo.model.User;
import org.kizombadev.spring.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService underTest;

    @Test
    public void getUserById() {
        User user = underTest.getUserById(1);
        Assertions.assertNotNull(user);
    }

    @Test
    public void userNotFound() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            underTest.getUserById(5);
        });
    }
}