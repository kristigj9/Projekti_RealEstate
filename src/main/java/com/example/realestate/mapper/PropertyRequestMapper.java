package com.example.realestate.mapper;

import com.example.realestate.dto.PropertyRequestDto;
import com.example.realestate.model.PropertyRequest;
import com.example.realestate.model.User;
import org.springframework.stereotype.Component;

@Component
public class PropertyRequestMapper {

    // Entity -> DTO
    public PropertyRequestDto toDto(PropertyRequest entity) {
        if (entity == null) return null;

        return PropertyRequestDto.builder()
                .id(entity.getId())
                .buyerId(entity.getBuyer() != null ? entity.getBuyer().getId() : null)
                .city(entity.getCity())
                .minPrice(entity.getMinPrice())
                .maxPrice(entity.getMaxPrice())
                .bedrooms(entity.getBedrooms())
                .bathrooms(entity.getBathrooms())
                .description(entity.getDescription())
                .contactNumber(entity.getContactNumber())
                .contactEmail(entity.getContactEmail())
                .status(entity.getStatus())
                .assignedAgentId(entity.getAssignedAgent() != null ? entity.getAssignedAgent().getId() : null)
                .build();
    }

    // DTO -> Entity
    public PropertyRequest toEntity(PropertyRequestDto dto) {
        if (dto == null) return null;

        PropertyRequest entity = new PropertyRequest();
        entity.setCity(dto.getCity());
        entity.setMinPrice(dto.getMinPrice());
        entity.setMaxPrice(dto.getMaxPrice());
        entity.setBedrooms(dto.getBedrooms());
        entity.setBathrooms(dto.getBathrooms());
        entity.setDescription(dto.getDescription());
        entity.setContactNumber(dto.getContactNumber());
        entity.setContactEmail(dto.getContactEmail());
        entity.setStatus(dto.getStatus());
        // buyer dhe assignedAgent vendosen në service përmes repo-ve
        return entity;
    }

    // Përditëson entity ekzistues nga DTO
    public void updateFromDto(PropertyRequestDto dto, PropertyRequest entity) {
        if (dto == null || entity == null) return;

        entity.setCity(dto.getCity());
        entity.setMinPrice(dto.getMinPrice());
        entity.setMaxPrice(dto.getMaxPrice());
        entity.setBedrooms(dto.getBedrooms());
        entity.setBathrooms(dto.getBathrooms());
        entity.setDescription(dto.getDescription());
        entity.setContactNumber(dto.getContactNumber());
        entity.setContactEmail(dto.getContactEmail());
        entity.setStatus(dto.getStatus());
        // assignedAgent dhe buyer mund të vendosen në service nëse duhen ndryshuar
    }
}