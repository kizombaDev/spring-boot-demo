package org.kizombadev.spring.demo.controller;

import lombok.AllArgsConstructor;
import org.kizombadev.spring.demo.controller.model.UserDto;
import org.kizombadev.spring.demo.converter.UserConverter;
import org.kizombadev.spring.demo.model.User;
import org.kizombadev.spring.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> userGetById(Integer id) {
        User user = userService.getUserById(id);
        UserDto userDto = UserConverter.convert(user);
        return ResponseEntity.ok(userDto);
    }
}
