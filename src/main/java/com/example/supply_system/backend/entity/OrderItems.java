package com.example.supply_system.backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "order_items")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double priceAtPurchase;

    @ManyToOne
    @JoinColumn (name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn (name = "product_id", nullable = false)
    private Products product;


}
