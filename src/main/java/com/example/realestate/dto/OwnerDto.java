package com.example.realestate.dto;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)

public class OwnerDto extends UserDto {
    LocalDateTime createdAt;
    private List<Long> propertyIds;

}