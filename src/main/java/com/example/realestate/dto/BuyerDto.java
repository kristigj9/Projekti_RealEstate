package com.example.realestate.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import jakarta.validation.constraints.*;
import lombok.experimental.SuperBuilder;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @SuperBuilder
public class BuyerDto extends UserDto {

        private Long id;

        @NotBlank(message = "Full name is required")
        private String name;

        @Email(message = "Email format is invalid")
        @NotBlank(message = "Email is required")
        private String email;

        @NotBlank(message = "Phone number is required")
        private String phone;

        @NotBlank(message = "Password is required")
        private String password;

        // Property IDs që blerësi i ka në favorites
        private Set<Long> favoritePropertyIds;

        // Kërkesat që ka bërë blerësi (BuyerRequest IDs)
        private List<Long> requestIds;
    }


