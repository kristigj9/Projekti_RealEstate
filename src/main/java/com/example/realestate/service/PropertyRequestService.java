package com.example.realestate.service;

import com.example.realestate.dto.PropertyRequestDto;

import java.util.List;

public interface PropertyRequestService {

    PropertyRequestDto createRequest(PropertyRequestDto dto);

    PropertyRequestDto getRequest(Long id);

    List<PropertyRequestDto> getAllRequests();

    PropertyRequestDto updateRequest(Long id, PropertyRequestDto dto);

    void deleteRequest(Long id);
}
