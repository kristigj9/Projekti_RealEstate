package com.example.realestate.service;

import com.example.realestate.dto.PropertyDto;
import com.example.realestate.mapper.PropertyMapper;
import com.example.realestate.model.Agent;
import com.example.realestate.model.Owner;
import com.example.realestate.model.Property;
import com.example.realestate.repository.AgentRepository;
import com.example.realestate.repository.ImageRepository;
import com.example.realestate.repository.OwnerRepository;
import com.example.realestate.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final OwnerRepository ownerRepository;
    private final AgentRepository agentRepository;
    private final ImageRepository imageRepository;

    private final PropertyMapper propertyMapper; // Manual or ModelMapper

    @Override
    public PropertyDto createProperty(PropertyDto dto) {

        Property property = propertyMapper.toEntity(dto);

        // Marrim owner-in
        Owner owner = ownerRepository.findById(dto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        property.setOwner(owner);

        // Marrim agentin nëse ekziston
        if (dto.getAgentId() != null) {
            Agent agent = agentRepository.findById(dto.getAgentId())
                    .orElseThrow(() -> new RuntimeException("Agent not found"));
            property.setAgent(agent);
        }

        // Save property
        property = propertyRepository.save(property);

        return propertyMapper.toDTO(property);
    }

    @Override
    public PropertyDto updateProperty(Long id, PropertyDto dto) {

        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        property.setTitle(dto.getTitle());
        property.setDescription(dto.getDescription());
        property.setPrice(dto.getPrice());
        property.setCity(dto.getCity());
        property.setAddress(dto.getAddress());
        property.setBedrooms(dto.getBedrooms());
        property.setBathrooms(dto.getBathrooms());
        property.setType(dto.getType());
        property.setStatus(dto.getStatus());

        property = propertyRepository.save(property);

        return propertyMapper.toDTO(property);
    }

    @Override
    public void deleteProperty(Long id) {
        if (!propertyRepository.existsById(id)) {
            throw new RuntimeException("Property not found");
        }
        propertyRepository.deleteById(id);
    }

    @Override
    public PropertyDto getPropertyById(Long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        return propertyMapper.toDTO(property);
    }

    @Override
    public List<PropertyDto> getAllProperties() {
        return propertyRepository.findAll()
                .stream()
                .map(propertyMapper::toDTO)
                .toList();
    }

    @Override
    public List<PropertyDto> getPropertiesByOwner(Long ownerId) {
        return propertyRepository.findByOwnerId(ownerId)
                .stream()
                .map(propertyMapper::toDTO)
                .toList();
    }

    @Override
    public List<PropertyDto> getPropertiesByAgent(Long agentId) {
        return propertyRepository.findByAgentId(agentId)
                .stream()
                .map(propertyMapper::toDTO)
                .toList();
    }

    @Override
    public PropertyDto markReserved(Long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        property.setStatus("RESERVED");
        return propertyMapper.toDTO(propertyRepository.save(property));
    }

    @Override
    public PropertyDto markSold(Long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        property.setStatus("SOLD");
        return propertyMapper.toDTO(propertyRepository.save(property));
    }

    @Override
    public PropertyDto markRented(Long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        property.setStatus("RENTED");
        return propertyMapper.toDTO(propertyRepository.save(property));
    }
}

