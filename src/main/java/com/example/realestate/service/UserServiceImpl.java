package com.example.realestate.service;

import com.example.realestate.dto.UserDto;
import com.example.realestate.mapper.UserMapper;
import com.example.realestate.model.User;
import com.example.realestate.repository.UserRepository;
import com.example.realestate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto dto) {
        User user = dto.toEntity();
        return UserDto.fromEntity(userRepository.save(user));
    }


    @Override
    public UserDto getUser(Long id) {
        return userRepository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    @Override
    public UserDto updateUser(Long id, UserDto dto) {
        // 1 Merr user nga DB
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        //  2 Përditëso fushat me mapper
        UserMapper.update(user, dto); // këtu përdor mapper-in
        // 3 Ruaj user në DB
        User updatedUser = userRepository.save(user);
        // 4 Kthe DTO
        return UserDto.fromEntity(updatedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream().map(UserDto::fromEntity).toList();
    }

    @Override
    public void disableUser(Long id) {
        User u = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        u.setActive(false);
        userRepository.save(u);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
