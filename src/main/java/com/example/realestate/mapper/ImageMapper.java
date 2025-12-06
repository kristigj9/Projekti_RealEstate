package com.example.realestate.mapper;

import com.example.realestate.dto.ImageDto;
import com.example.realestate.model.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {

    // DTO -> Entity
    public Image toEntity(ImageDto dto) {
        if (dto == null) return null;

        Image image = new Image();
        image.setUrl(dto.getUrl());
        image.setDescription(dto.getDescription());
        image.setProperty(dto.getPropertyId());
        return image;
    }

    // Entity -> DTO
    public ImageDto toDto(Image entity) {
        if (entity == null) return null;

        ImageDto dto = new ImageDto();
        dto.setId(entity.getId());
        dto.setUrl(entity.getUrl());
        dto.setDescription(entity.getDescription());
        dto.setPropertyId(entity.getProperty());
        return dto;
    }

    // Përditëson entity ekzistues nga DTO
    public void updateFromDto(ImageDto dto, Image entity) {
        if (dto == null || entity == null) return;

        if (dto.getUrl() != null) {
            entity.setUrl(dto.getUrl());
        }
        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }
        if (dto.getPropertyId() != null) {
            entity.setProperty(dto.getPropertyId());
        }
    }
}
