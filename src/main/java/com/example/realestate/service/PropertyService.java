package com.example.realestate.service;

import com.example.realestate.dto.PropertyDto;
import com.example.realestate.model.Property;
import com.example.realestate.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public interface PropertyService {

        PropertyDto createProperty(PropertyDto dto);

        PropertyDto updateProperty(Long id, PropertyDto dto);

        void deleteProperty(Long id);

        PropertyDto getPropertyById(Long id);

        List<PropertyDto> getAllProperties();

        List<PropertyDto> getPropertiesByOwner(Long ownerId);

        List<PropertyDto> getPropertiesByAgent(Long agentId);

        PropertyDto markReserved(Long id);

        PropertyDto markSold(Long id);

        PropertyDto markRented(Long id);
    }


