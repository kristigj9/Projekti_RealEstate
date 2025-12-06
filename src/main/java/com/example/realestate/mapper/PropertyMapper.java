package com.example.realestate.mapper;

import com.example.realestate.dto.ImageDto;
import com.example.realestate.dto.PropertyDto;
import com.example.realestate.model.Property;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PropertyMapper {

    public PropertyDto toDTO(Property entity) {
        PropertyDto dto = new PropertyDto();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setCity(entity.getCity());
        dto.setAddress(entity.getAddress());
        dto.setBedrooms(entity.getBedrooms());
        dto.setBathrooms(entity.getBathrooms());
        dto.setType(entity.getType());
        dto.setStatus(entity.getStatus());

        dto.setOwnerId(entity.getOwner().getId());
        dto.setAgentId(entity.getAgent() != null ? entity.getAgent().getId() : null);

        if (entity.getImages() != null) {
            List<ImageDto> images = entity.getImages().stream()
                    .map(i -> new ImageDto(i.getId(), i.getUrl()))
                    .toList();

            dto.setImages(images);
        }

        return dto;
    }

    public Property toEntity(PropertyDto dto) {
        Property entity = new Property();

        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setCity(dto.getCity());
        entity.setAddress(dto.getAddress());
        entity.setBedrooms(dto.getBedrooms());
        entity.setBathrooms(dto.getBathrooms());
        entity.setType(dto.getType());
        entity.setStatus(dto.getStatus());

        return entity;
    }
}

