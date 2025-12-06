package com.example.realestate.repository;

import com.example.realestate.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    boolean existsByLicenseNumber(String licenseNumber);
}