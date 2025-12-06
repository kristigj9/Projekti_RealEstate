package com.example.realestate.service;

import com.example.realestate.dto.BuyerDto;
import com.example.realestate.mapper.BuyerMapper;
import com.example.realestate.model.Buyer;
import com.example.realestate.model.Property;
import com.example.realestate.model.PropertyRequest;
import com.example.realestate.repository.BuyerRepository;
import com.example.realestate.repository.PropertyRepository;
import com.example.realestate.repository.PropertyRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepo;
    private final PropertyRepository propertyRepo;
    private final PropertyRequestRepository requestRepo;
    private final BuyerMapper mapper;


    @Override
    public BuyerDto createBuyer(BuyerDto dto) {
        Buyer buyer = mapper.toEntity(dto);

        buyer.setFavoriteProperties(getPropertiesFromIds(dto.getFavoritePropertyIds()));
        buyer.setRequests(getRequestsFromIds(dto.getRequestIds()));

        return mapper.toDto(buyerRepo.save(buyer));
    }

    @Override
    public BuyerDto updateBuyer(Long id, BuyerDto dto) {
        Buyer buyer = buyerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Buyer not found"));

        mapper.updateEntity(buyer, dto);

        buyer.setFavoriteProperties(getPropertiesFromIds(dto.getFavoritePropertyIds()));
        buyer.setRequests(getRequestsFromIds(dto.getRequestIds()));

        return mapper.toDto(buyerRepo.save(buyer));
    }

    @Override
    public BuyerDto getBuyer(Long id) {
        Buyer buyer = buyerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Buyer not found"));
        return mapper.toDto(buyer);
    }

    // ===========================
    // PRIVATE HELPERS
    // ===========================
    private Set<Property> getPropertiesFromIds(Set<Long> ids) {
        if (ids == null) return Set.of();
        return new HashSet<>(propertyRepo.findAllById(ids));
    }

    private List<PropertyRequest> getRequestsFromIds(List<Long> ids) {
        if (ids == null) return List.of();
        return requestRepo.findAllById(ids);
    }

    @Override
    public List<BuyerDto> getAllBuyers() {
        List<Buyer> buyers = buyerRepo.findAll(); // merr të gjithë buyer-at nga database
        return buyers.stream()
                .map(mapper::toDto)
                .toList(); // konverton çdo Buyer në BuyerDto
    }

    @Override
    public void deleteBuyer(Long id) {
        Buyer buyer = buyerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Buyer not found"));
        buyerRepo.delete(buyer);
    }

}
