package com.example.supply_system.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "warehouse")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long warehouseId;

    @Column(name="warehouse_product_name", length = 100)
    private String name;

    @Column(name="warehouse_location",  length = 100)
    private String location;

    @Column(name = "warehouse_product_stock" , nullable=false)
    private long stock;
}
