package org.kizombadev.spring.demo.service;

import lombok.AllArgsConstructor;
import org.kizombadev.spring.demo.model.User;
import org.kizombadev.spring.demo.repository.UserRepository;
import org.kizombadev.spring.demo.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> NotFoundException.create(String.valueOf(id)));
    }
}
