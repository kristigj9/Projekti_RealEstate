package com.example.realestate.model;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String role;
    private Status status;
    private String username;
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private boolean active;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }



}