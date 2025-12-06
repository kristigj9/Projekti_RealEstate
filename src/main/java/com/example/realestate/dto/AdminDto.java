package com.example.realestate.dto;

import com.example.realestate.model.Admin;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password; // nëse s'do të dërgohet, hiqe

    public static AdminDto fromEntity(Admin admin) {
        if (admin == null) return null;

        return AdminDto.builder()
                .id(admin.getId())
                .name(admin.getName())
                .email(admin.getEmail())
                .phone(admin.getPhone())
                .password(admin.getPassword())
                .build();
    }

    public Admin toEntity() {
        Admin admin = new Admin();
        admin.setId(this.id);
        admin.setName(this.name);
        admin.setEmail(this.email);
        admin.setPhone(this.phone);
        admin.setPassword(this.password);
        return admin;
    }
}
