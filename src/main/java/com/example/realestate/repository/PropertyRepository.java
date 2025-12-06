package com.example.realestate.repository;

import com.example.realestate.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
        List<Property> findByCity(String city);
        List<Property> findByForRent(boolean forRent);
        List<Property> findByPriceBetween(double min, double max);
        List<Property> findByType(String type); // ku type = "Rent" ose "Sale"

    // Merr të gjitha pronat sipas owner_id
    List<Property> findByOwnerId(Long ownerId);

    // Nëse të duhet edhe për agjentin:
    List<Property> findByAgentId(Long agentId);
    }


