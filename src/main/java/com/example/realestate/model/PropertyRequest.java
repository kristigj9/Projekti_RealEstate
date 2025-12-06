package com.example.realestate.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "property_requests")
@Getter @Setter @NoArgsConstructor
public class PropertyRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    private String city;
    private Double minPrice;
    private Double maxPrice;
    private Integer bedrooms;
    private Integer bathrooms;
    private String description;
    private String contactNumber;
    private String contactEmail;
    private String status; // PENDING, APPROVED, REJECTED

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent assignedAgent;
}
