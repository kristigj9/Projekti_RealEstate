package com.example.realestate.repository;

import com.example.realestate.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    // opsionale: mund të shtosh query të veçantë
}
