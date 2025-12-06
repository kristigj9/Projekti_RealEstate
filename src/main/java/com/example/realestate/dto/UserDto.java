package com.example.realestate.dto;

import com.example.realestate.model.Role;
import com.example.realestate.model.User;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Data
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be 2-50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Invalid phone number")
    private String phone;

    private boolean enabled;

    @NotBlank(message = "Role is required")
    private String role; // ADMIN, AGENT, OWNER, BUYER
    private String username;
    private String password;
    private String status;
    private LocalDateTime createdAt;

    // DTO → Entity
    public User toEntity() {
        return User.builder()
                .id(this.id)
                .username(this.username)
                .email(this.email)
                .build();
    }

    // Entity → DTO
    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName()) // ✅ String direkt, pa .name()
                .email(user.getEmail())
                .role(user.getRole()) // enum → .name()
                .status(user.getStatus() != null ? user.getStatus().name() : null) // enum → .name()
                .createdAt(user.getCreatedAt())
                .build();
    }
}