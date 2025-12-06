package com.example.realestate.service;

import com.example.realestate.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto dto);
    UserDto updateUser(Long id, UserDto dto);
    UserDto getUser(Long id);
    List<UserDto> getAllUsers();
    void disableUser(Long id);
    void deleteUser(Long id);
}
