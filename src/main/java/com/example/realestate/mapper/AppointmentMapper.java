package com.example.realestate.mapper;

import com.example.realestate.dto.AppointmentDto;
import com.example.realestate.model.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    // Convert Appointment entity → AppointmentDto
    public AppointmentDto toDto(Appointment appointment) {
        if (appointment == null) return null;

        return AppointmentDto.builder()
                .id(appointment.getId())
                .appointmentDate(appointment.getAppointmentDate())
                .status(appointment.getStatus())
                .buyerId(appointment.getBuyer() != null ? appointment.getBuyer().getId() : null)
                .agentId(appointment.getAgent() != null ? appointment.getAgent().getId() : null)
                .propertyId(appointment.getProperty() != null ? appointment.getProperty().getId() : null)
                .notes(appointment.getNotes())
                .build();
    }

    // Convert AppointmentDto → Appointment entity
    public Appointment toEntity(AppointmentDto dto) {
        if (dto == null) return null;

        Appointment appointment = new Appointment();
        appointment.setId(dto.getId());
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setStatus(dto.getStatus());
        // Buyer, Agent dhe Property duhet të vendosen në Service kur bëhet save
        appointment.setNotes(dto.getNotes());
        return appointment;
    }

    // Update existing Appointment entity nga DTO
    public void updateFromDto(Appointment appointment, AppointmentDto dto) {
        if (dto.getAppointmentDate() != null) appointment.setAppointmentDate(dto.getAppointmentDate());
        if (dto.getStatus() != null) appointment.setStatus(dto.getStatus());
        if (dto.getNotes() != null) appointment.setNotes(dto.getNotes());
        // Buyer, Agent, Property mund të menaxhohen në Service
    }
}
