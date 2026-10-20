package com.example.supply_system.backend.controller;

import com.example.supply_system.backend.entity.Order;
import com.example.supply_system.backend.entity.OrderItems;
import com.example.supply_system.backend.service.OrderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Data
    public static class CheckoutRequest{
        private Long customerId;
        private Long hubId;
        private List<OrderService.OrderItemRequest> items;
    }

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody CheckoutRequest request){
        try{
            Order completedOrder = orderService.placeOrder(
                    request.getCustomerId(),
                    request.getHubId(),
                    request.getItems()
            );
            return new ResponseEntity<>(completedOrder, HttpStatus.CREATED);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}

