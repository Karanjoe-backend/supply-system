package com.example.supply_system.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "local_hub")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocalHub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hubId;

    @Column(name = "hub_name", nullable = false, length = 100)
    private String name;

    @Column(name = "hub_location", nullable = false, length = 100)
    private String location;

    @ManyToOne
    @JoinColumn(name="warehouse_id", nullable = false)
    private Warehouse warehouse;

    @OneToMany(mappedBy = "localHub", cascade = CascadeType.ALL)
    private List<HubProduct> hubProducts;


}
