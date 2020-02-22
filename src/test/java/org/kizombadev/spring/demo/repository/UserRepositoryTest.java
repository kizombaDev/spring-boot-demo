package org.kizombadev.spring.demo.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kizombadev.spring.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        User user = new User(5, "Marcel", true);
        userRepository.save(user);
        userRepository.flush();

        Optional<User> actualUser = userRepository.findById(5);

        assertTrue(actualUser.isPresent());
        assertEquals(user, actualUser.get());
    }

    @Test()
    public void validation() {
        User user = new User(6, "A", true);
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            userRepository.save(user);
            userRepository.flush();
        });
    }
}