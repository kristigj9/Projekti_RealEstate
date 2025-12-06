package com.example.realestate.service;

import com.example.realestate.dto.PropertyRequestDto;
import com.example.realestate.mapper.PropertyRequestMapper;
import com.example.realestate.model.PropertyRequest;
import com.example.realestate.repository.PropertyRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PropertyRequestServiceImpl implements PropertyRequestService {

    private final PropertyRequestRepository repository;
    private final PropertyRequestMapper mapper;

    @Override
    public PropertyRequestDto createRequest(PropertyRequestDto dto) {
        PropertyRequest entity = mapper.toEntity(dto);
        PropertyRequest saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public PropertyRequestDto getRequest(Long id) {
        PropertyRequest request = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("PropertyRequest not found with id: " + id));
        return mapper.toDto(request);
    }

    @Override
    public List<PropertyRequestDto> getAllRequests() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PropertyRequestDto updateRequest(Long id, PropertyRequestDto dto) {
        PropertyRequest existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("PropertyRequest not found with id: " + id));
        mapper.updateFromDto(dto, existing);
        PropertyRequest updated = repository.save(existing);
        return mapper.toDto(updated);
    }

    @Override
    public void deleteRequest(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("PropertyRequest not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
