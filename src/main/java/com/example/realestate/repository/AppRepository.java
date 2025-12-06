package com.example.realestate.repository;

import com.example.realestate.model.App;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppRepository extends JpaRepository<App, Long> {
    Optional<App> findByUsername(String username);
    boolean existsByUsername(String username);
}