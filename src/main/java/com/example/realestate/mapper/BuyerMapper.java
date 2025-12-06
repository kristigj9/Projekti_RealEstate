package com.example.realestate.mapper;

import com.example.realestate.dto.BuyerDto;
import com.example.realestate.model.Buyer;
import org.springframework.stereotype.Component;

@Component
public class BuyerMapper {

    // Convert Buyer entity → BuyerDto
    public BuyerDto toDto(Buyer buyer) {
        if (buyer == null) return null;

        return BuyerDto.builder()
                .id(buyer.getId())
                .name(buyer.getName())
                .email(buyer.getEmail())
                .phone(buyer.getPhone())
                .password(buyer.getPassword())
                // shtoni fusha të tjera sipas modelit të Buyer
                .build();
    }

    // Convert BuyerDto → Buyer entity
    public Buyer toEntity(BuyerDto dto) {
        if (dto == null) return null;

        Buyer buyer = new Buyer();
        buyer.setId(dto.getId());
        buyer.setName(dto.getName());
        buyer.setEmail(dto.getEmail());
        buyer.setPhone(dto.getPhone());
        buyer.setPassword(dto.getPassword());
        // shtoni fusha të tjera sipas modelit të Buyer
        return buyer;
    }

    // Update existing Buyer entity nga DTO
    public void updateEntity(Buyer buyer, BuyerDto dto) {
        if (dto.getName() != null) buyer.setName(dto.getName());
        if (dto.getEmail() != null) buyer.setEmail(dto.getEmail());
        if (dto.getPhone() != null) buyer.setPhone(dto.getPhone());
        if (dto.getPassword() != null) buyer.setPassword(dto.getPassword());
    }}
