package com.example.realestate.dto;

import com.example.realestate.model.PropertyRequestStatus;
import com.example.realestate.model.PropertyStatus;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PropertyRequestDto {
    private Long id;

    @NotNull(message = "Buyer ID is required")
    private Long buyerId;

    @NotBlank(message = "City is required")
    private String city;

    @NotNull(message = "Min price is required")
    @PositiveOrZero(message = "Min price must be positive or zero")
    private Double minPrice;

    @NotNull(message = "Max price is required")
    @Positive(message = "Max price must be positive")
    private Double maxPrice;

    @NotNull(message = "Bedrooms is required")
    @Min(value = 0, message = "Bedrooms must be 0 or more")
    private Integer bedrooms;

    @NotNull(message = "Bathrooms is required")
    @Min(value = 0, message = "Bathrooms must be 0 or more")
    private Integer bathrooms;

    private String description;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Invalid contact number")
    private String contactNumber;

    @NotBlank(message = "Contact email is required")
    @Email(message = "Invalid contact email")
    private String contactEmail;

    private String status; // PENDING, APPROVED, REJECTED

    private Long assignedAgentId;
}
