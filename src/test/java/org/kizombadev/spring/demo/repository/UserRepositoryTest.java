package org.kizombadev.spring.demo.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kizombadev.spring.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        User user = new User(5, "Marcel", true);
        userRepository.save(user);

        Optional<User> actualUser = userRepository.findById(5);

        assertTrue(actualUser.isPresent());
        assertEquals(user, actualUser.get());
    }

}