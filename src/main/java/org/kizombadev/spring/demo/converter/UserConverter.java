package org.kizombadev.spring.demo.converter;

import org.kizombadev.spring.demo.controller.model.UserDto;
import org.kizombadev.spring.demo.model.User;
import org.modelmapper.ModelMapper;

public final class UserConverter {
    private static final ModelMapper modelMapper = new ModelMapper();
    public static UserDto convert(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
