package com.example.realestate.service;

import com.example.realestate.dto.OwnerDto;
import com.example.realestate.mapper.OwnerMapper;
import com.example.realestate.model.Owner;
import com.example.realestate.model.User;
import com.example.realestate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional

public class OwnerServiceImpl implements OwnerService {

    private final UserRepository userRepository;
    private final OwnerMapper ownerMapper;

    @Override
    public List<OwnerDto> getAllOwners() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .filter(user -> user instanceof Owner)
                .map(user -> ownerMapper.toDto((Owner) user))
                .collect(Collectors.toList());
    }

    @Override
    public OwnerDto getOwnerById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        if (!(user instanceof Owner)) {
            throw new RuntimeException("User with id " + id + " is not an Owner");
        }
        return ownerMapper.toDto((Owner) user);
    }

    @Override
    public OwnerDto createOwner(OwnerDto dto) {
        Owner owner = ownerMapper.toEntity(dto);
        Owner saved = userRepository.save(owner);
        return ownerMapper.toDto(saved);
    }

    @Override
    public OwnerDto updateOwner(Long id, OwnerDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        if (!(user instanceof Owner)) {
            throw new RuntimeException("User with id " + id + " is not an Owner");
        }
        Owner owner = (Owner) user;
        ownerMapper.updateFromDto(dto, owner);
        Owner updated = userRepository.save(owner);
        return ownerMapper.toDto(updated);
    }

    @Override
    public void deleteOwner(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        if (!(user instanceof Owner)) {
            throw new RuntimeException("User with id " + id + " is not an Owner");
        }
        userRepository.delete(user);
    }
}

