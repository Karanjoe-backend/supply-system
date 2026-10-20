package com.example.supply_system.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.supply_system.backend.entity.CustomerProfile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {

    Optional<CustomerProfile> findByEmail(String email);

    boolean existsByEmail(String email);
}
