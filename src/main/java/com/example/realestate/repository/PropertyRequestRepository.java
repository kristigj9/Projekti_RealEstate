package com.example.realestate.repository;

import com.example.realestate.model.PropertyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRequestRepository extends JpaRepository<PropertyRequest, Long> {

    List<PropertyRequest> findByBuyerId(Long buyerId);

    List<PropertyRequest> findByAssignedAgentId(Long agentId);

    List<PropertyRequest> findByStatus(String status); // PENDING, APPROVED...
}
