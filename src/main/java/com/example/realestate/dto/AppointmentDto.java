package com.example.realestate.dto;

import com.example.realestate.model.Appointment_Status;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class AppointmentDto {
    private Long id;

    @NotNull(message = "Appointment date is required")
    private LocalDateTime appointmentDate;

    @NotBlank(message = "Status is required")
    private Appointment_Status status; // NEW, COMPLETED, CANCELLED

    @NotNull(message = "Buyer ID is required")
    private Long buyerId;

    @NotNull(message = "Agent ID is required")
    private Long agentId;

    @NotNull(message = "Property ID is required")
    private Long propertyId;
    private String notes; //Shenime per takimin

}
