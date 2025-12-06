package com.example.realestate.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "agents")
@Getter @Setter @NoArgsConstructor
public class Agent extends User {
    private String licenseNumber;

    @OneToMany(mappedBy = "agent")
    private List<Property> assignedProperties;

    @OneToMany(mappedBy = "assignedAgent")
    private List<PropertyRequest> assignedRequests;
}