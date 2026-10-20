package com.example.supply_system.backend.service;

import com.example.supply_system.backend.entity.HubProduct;
import com.example.supply_system.backend.entity.LocalHub;
import com.example.supply_system.backend.entity.Products;
import com.example.supply_system.backend.repository.HubProductRepository;
import com.example.supply_system.backend.repository.LocalHubRepository;
import com.example.supply_system.backend.repository.ProductsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HubStockService {

    private final HubProductRepository hubRepository;
    private final LocalHubRepository localRepository;
    private final ProductsRepository productRepository;

    @Transactional
    public HubProduct addOrUpdateStock(Long hubId, Long productId, Long quantity){

        LocalHub hub = localRepository.findById(hubId)
                .orElseThrow(() -> new RuntimeException("No Hub ID is found with local hub" +hubId));

        Products product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("No Product ID is found with the product" +productId));

        HubProduct hubProduct = hubRepository.findByHubIdAndProductId(hubId, productId)
                .orElse(HubProduct.builder()
                        .localHub(hub)
                        .product(product)
                        .stock(0L)
                        .build());

        hubProduct.setStock(hubProduct.getStock() + quantity);
        return hubRepository.save(hubProduct);

    }

}
