package com.example.realestate.service;

import com.example.realestate.dto.BuyerDto;
import java.util.List;

public interface BuyerService {
    BuyerDto createBuyer(BuyerDto dto);
    BuyerDto updateBuyer(Long id, BuyerDto dto);
    BuyerDto getBuyer(Long id);
    List<BuyerDto> getAllBuyers();
    void deleteBuyer(Long id);
}
