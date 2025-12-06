package com.example.realestate.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "appointments")
@Getter @Setter @NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentDate;
    private Appointment_Status status; // NEW, COMPLETED, CANCELLED

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @Column(length = 1000)
    private String notes; // fushë për komente ose shënime mbi takimin
}
