package com.example.realestate.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import java.util.List;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AgentDto extends UserDto {
    @NotBlank(message = "License number is required")
    private String licenseNumber;

    private List<@NotNull Long> assignedPropertyIds;
    private List<@NotNull Long> assignedRequestIds;
}

