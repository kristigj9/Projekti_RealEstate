package com.example.realestate.model;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Entity

@Table(name = "owners")
@Getter @Setter @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public class Owner extends User {
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Property> properties;
}
