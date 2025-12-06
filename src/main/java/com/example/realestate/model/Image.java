package com.example.realestate.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "images")
@Getter @Setter @NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private String description;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;
}
