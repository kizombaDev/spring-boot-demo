package org.kizombadev.spring.demo.service;

import lombok.AllArgsConstructor;
import org.kizombadev.spring.demo.exception.NotFoundException;
import org.kizombadev.spring.demo.model.User;
import org.kizombadev.spring.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    // private KafkaTemplate<String, String> kafkaTemplate;

    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw NotFoundException.create(String.valueOf(id));
        }

        // kafkaTemplate.send("test-topic", String.format("User %s is created", user));

        return user.get();
    }
}
