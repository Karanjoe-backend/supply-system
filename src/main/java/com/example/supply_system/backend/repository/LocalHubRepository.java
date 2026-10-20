package com.example.supply_system.backend.repository;

import com.example.supply_system.backend.entity.HubProduct;
import com.example.supply_system.backend.entity.LocalHub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalHubRepository extends JpaRepository<LocalHub, Long> {

    @Query("SELECT lh FROM LocalHub lh WHERE lh.warehouse.warehouseId = :warehouseId")
    List<LocalHub> findByWarehouseId(@Param("warehouseId") Long warehouseId);
}
