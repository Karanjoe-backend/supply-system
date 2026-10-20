package com.example.supply_system.backend.repository;

import com.example.supply_system.backend.entity.HubProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HubProductRepository extends JpaRepository<HubProduct, Long>{
    @Query("SELECT hp FROM HubProduct hp WHERE hp.localHub.hubId = :hubId AND hp.product.productId = :productId")
    Optional<HubProduct> findByHubIdAndProductId (@Param("hubId") Long hubId, @Param("productId") Long productId);

    @Query("SELECT hp FROM HubProduct hp WHERE hp.localHub.hubId = :hubId")
    List<HubProduct> findByHubId(@Param("hubId") Long hubId);
}
