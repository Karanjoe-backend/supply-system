package com.example.supply_system.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table( name = "customer_details")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "full_name", nullable = false, length = 100)
    private String customerName;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column( name = "customer_location" , nullable = false, length = 50)
    private String customerLocation;

    @Column(name = "phone_number", nullable = false)
    private String phone_no;


}
