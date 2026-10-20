package com.example.supply_system.backend.repository;

import com.example.supply_system.backend.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
//    List<Products> findByWarehouseId(Long warehouseId);
    @Query("SELECT p FROM Products p WHERE p.warehouse.warehouseId = :warehouseId")
    List<Products> findByWarehouseId(@Param("warehouseId") Long warehouseId);
}
