package com.example.realestate.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "admins")
@Getter
@Setter
public class Admin extends User {

    public Admin() {
        super();
        super.setRole("ADMIN");  // vendose rolin këtu
    }
}
