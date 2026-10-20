package com.example.supply_system.backend.controller;

import com.example.supply_system.backend.entity.HubProduct;
import com.example.supply_system.backend.service.HubStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/hubs/")
@RequiredArgsConstructor
public class HubStockController {

    private final HubStockService hubStockService;

//    @GetMapping("/test") public ResponseEntity<String> testEndpoint() {
//        return ResponseEntity.ok("HubStockController is ALIVE!"); }




    @PostMapping("{hubId}/products/{productId}/stock")
    public ResponseEntity<?> updateStock(@PathVariable Long hubId,
                                              @PathVariable Long productId,
                                              @RequestParam  Long quantity){
        try {
            HubProduct hubProduct = hubStockService.addOrUpdateStock(hubId, productId, quantity);
            return ResponseEntity.ok(hubProduct);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
