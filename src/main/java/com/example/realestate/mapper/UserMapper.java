package com.example.realestate.mapper;

import com.example.realestate.dto.UserDto;
import com.example.realestate.model.Role;
import com.example.realestate.model.User;
import com.example.realestate.model.Status;

public class UserMapper {

    public static UserDto fromEntity(User user) {
        if (user == null) return null;

        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .createdAt(user.getCreatedAt())
                .role(user.getRole())
                .build();
    }
    public static void update(User user, UserDto dto) {
        if (dto.getUsername() != null) user.setUsername(dto.getUsername());
        if (dto.getName() != null) user.setName(dto.getName());
        if (dto.getEmail() != null) user.setEmail(dto.getEmail());
        if (dto.getPassword() != null) user.setPassword(dto.getPassword());
        if (dto.getRole() != null) user.setRole(dto.getRole());
        if (dto.getStatus() != null) user.setStatus(Status.valueOf(dto.getStatus()));
    }

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .status(user.getStatus() != null ? user.getStatus().name() : null)
                .createdAt(user.getCreatedAt())
                .build();
    }

    public static User toEntity(UserDto dto) {
        return User.builder()
                .username(dto.getUsername())
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(dto.getRole())
                .status(dto.getStatus() != null ? Status.valueOf(dto.getStatus()) : null)
                .build();
    }
}


