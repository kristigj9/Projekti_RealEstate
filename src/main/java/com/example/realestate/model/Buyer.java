package com.example.realestate.model;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Entity
@SuperBuilder
@Table(name = "buyers")
@Getter @Setter @NoArgsConstructor
public class Buyer extends User {
    @ManyToMany
    @JoinTable(
            name = "buyer_favorites",
            joinColumns = @JoinColumn(name = "buyer_id"),
            inverseJoinColumns = @JoinColumn(name = "property_id")
    )
    private Set<Property> favoriteProperties;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private List<PropertyRequest> requests;
}
