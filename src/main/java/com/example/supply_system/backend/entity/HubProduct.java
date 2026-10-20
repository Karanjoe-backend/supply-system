package com.example.supply_system.backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "hub_products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HubProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hubProductId;

//    @Column(name = "hub_product_name",  length = 100)
//    private String name;

    @Column(name="hub_stock")
    private Long stock;

    @ManyToOne
    @JoinColumn(name = "hub_id", nullable = false)
    private LocalHub localHub;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

}
