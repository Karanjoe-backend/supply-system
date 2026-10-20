package com.example.supply_system.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(name = "product_name", nullable = false, length = 100)
    private String name;

    @Column(name = "product_stock", nullable = false)
    private Long stock;

    @Column(name = "product_price", nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;
}
