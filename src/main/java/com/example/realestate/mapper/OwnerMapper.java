package com.example.realestate.mapper;

import com.example.realestate.dto.OwnerDto;
import com.example.realestate.dto.UserDto;
import com.example.realestate.model.Owner;
import com.example.realestate.model.User;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {

    // ----------------------------
    // Kthen çdo User në UserDto
    // Kontrollon automatikisht nëse është Owner
    // ----------------------------
    public UserDto toDto(User user) {
        if (user == null) return null;

        if (user instanceof Owner owner) {
            return toOwnerDto(owner);
        }

        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    // ----------------------------
    // Kthen Owner specifik në OwnerDto
    // ----------------------------
    public OwnerDto toOwnerDto(Owner owner) {
        if (owner == null) return null;

        return OwnerDto.builder()
                .id(owner.getId())
                .name(owner.getName())
                .email(owner.getEmail())
                .phone(owner.getPhone())
                // mund të shtosh fusha të tjera specifike për Owner
                .build();
    }

    // ----------------------------
    // Kthen OwnerDto në Owner Entity
    // ----------------------------
    public Owner toEntity(OwnerDto dto) {
        if (dto == null) return null;

        return Owner.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                // mund të shtosh fusha të tjera specifike për Owner
                .build();
    }

        public OwnerDto toDto(Owner owner) {
            if (owner == null) return null;
            return OwnerDto.builder()
                    .id(owner.getId())
                    .name(owner.getName())
                    .email(owner.getEmail())
                    .build();
        }
        public void updateFromDto(OwnerDto dto, Owner owner) {
            if (dto == null || owner == null) return;
            owner.setName(dto.getName());
            owner.setEmail(dto.getEmail());
            // shto fushat e tjera që ke në Owner
        }
    }
