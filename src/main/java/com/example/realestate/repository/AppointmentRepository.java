package com.example.realestate.repository;

import com.example.realestate.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByBuyerId(Long buyerId);

    List<Appointment> findByAgentId(Long agentId);

    List<Appointment> findByPropertyId(Long propertyId);

    List<Appointment> findByAppointmentDateBetween(LocalDateTime start, LocalDateTime end);
}

