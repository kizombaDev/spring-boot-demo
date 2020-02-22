package org.kizombadev.spring.demo.service;

import lombok.AllArgsConstructor;
import org.kizombadev.spring.demo.model.User;
import org.kizombadev.spring.demo.properties.DemoProperties;
import org.kizombadev.spring.demo.repository.UserRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(IllegalStateException::new);
    }
}
