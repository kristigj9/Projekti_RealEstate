package com.example.realestate.dto;

import com.example.realestate.model.Property;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Data
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class ImageDto {
    private Long id;
    private String url;
    private String description;
    private Property propertyId;

    public ImageDto(Long id, String url) {
        this.id = id;
        this.url = url;
    }
}
