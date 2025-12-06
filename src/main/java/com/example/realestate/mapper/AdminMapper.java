package com.example.realestate.mapper;

import com.example.realestate.dto.AdminDto;
import com.example.realestate.model.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {

    // Convert Admin entity → AdminDto
    public static AdminDto fromEntity(Admin admin) {
        if (admin == null) return null;

        return AdminDto.builder()
                .id(admin.getId())
                .name(admin.getName())
                .email(admin.getEmail())
                .phone(admin.getPhone())
                .password(admin.getPassword()) // nëse Admin ka fushë password
                .build();
    }

    // Convert AdminDto → Admin entity
    public static Admin toEntity(AdminDto dto) {
        if (dto == null) return null;

        Admin admin = new Admin();
        admin.setId(dto.getId());
        admin.setName(dto.getName());
        admin.setEmail(dto.getEmail());
        admin.setPhone(dto.getPhone());
        admin.setPassword(dto.getPassword());
        return admin;
    }

    // Update existing Admin entity nga DTO
    public static void updateEntity(Admin admin, AdminDto dto) {
        if (dto.getName() != null) admin.setName(dto.getName());
        if (dto.getEmail() != null) admin.setEmail(dto.getEmail());
        if (dto.getPhone() != null) admin.setPhone(dto.getPhone());
        if (dto.getPassword() != null) admin.setPassword(dto.getPassword());
    }

    //Kjo është metoda që duhet për AdminServiceImpl
    public AdminDto toDto(Admin admin) {
        if (admin == null) return null;

        return AdminDto.builder()
                .id(admin.getId())
                .name(admin.getName())
                .email(admin.getEmail())
                .phone(admin.getPhone())
                .password(admin.getPassword())
                .build();
    }
}
