package com.example.realestate.dto;

import com.example.realestate.model.PropertyStatus;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {

    private Long id;
    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title max 100 characters")
    private String title;
    @NotBlank(message = "Number of Bathrooms is required")
    private Integer bathrooms;
    @NotBlank(message = "Number of Bedrooms is required")
    private Integer bedrooms;
    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "City is required")
    private String city;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotBlank(message = "Type is required")
    @Pattern(regexp = "RENT|SALE", message = "Type must be RENT or SALE")
    private String type;

    @NotBlank(message = "Status is required")
    private String status; // PENDING, APPROVED, RESERVED, SOLD, RENTED

    @NotNull(message = "Owner ID is required")
    private Long ownerId;

    private Long agentId;
    private List<ImageDto> images;

    private List<@NotNull Long> imageIds;


}



