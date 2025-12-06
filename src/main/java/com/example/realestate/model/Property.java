package com.example.realestate.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "properties")
@Getter @Setter @NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean forRent;  // <-- Shto këtë fushë
    private String title;
    private String description;
    private String address;
    private String city;
    private Double price;
    private String type; // RENT / SALE
    private String status;// PENDING, APPROVED, RESERVED, SOLD, RENTED
    private int bedrooms;
    private int bathrooms;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Image> images;

    @ManyToMany(mappedBy = "favoriteProperties")
    private Set<Buyer> likedByBuyers;
}