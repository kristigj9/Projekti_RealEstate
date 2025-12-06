package com.example.realestate.service;

import com.example.realestate.dto.OwnerDto;

import java.util.List;

public interface OwnerService {
    OwnerDto createOwner(OwnerDto ownerDto);
    OwnerDto getOwnerById(Long id);
    List<OwnerDto> getAllOwners();
    OwnerDto updateOwner(Long id, OwnerDto ownerDto);
    void deleteOwner(Long id);
}

