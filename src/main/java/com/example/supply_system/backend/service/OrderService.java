package com.example.supply_system.backend.service;


import com.example.supply_system.backend.entity.CustomerProfile;
import com.example.supply_system.backend.entity.HubProduct;
import com.example.supply_system.backend.entity.Order;
import com.example.supply_system.backend.entity.OrderItems;
import com.example.supply_system.backend.repository.CustomerProfileRepository;
import com.example.supply_system.backend.repository.HubProductRepository;
import com.example.supply_system.backend.repository.OrderItemsRepository;
import com.example.supply_system.backend.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerProfileRepository customerRepository;
    private final OrderRepository orderRepository;
    private final HubProductRepository hubRepository;

    public record OrderItemRequest(Long productId, Integer quantity, Double unitPrice){}

        @Transactional
        public Order placeOrder(Long customerId, Long hubId, List<OrderItemRequest> itemRequests) throws Exception {

            CustomerProfile customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new RuntimeException("No customer found with the ID" + customerId));

            Order order = Order.builder()
                    .customerProfile(customer)
                    .totalAmt(0.0)
                    .orderItems(new ArrayList<>())
                    .build();

            double grandTotal = 0.0;

            for(OrderItemRequest itemReq : itemRequests ) {

                HubProduct hubStock = hubRepository.findByHubIdAndProductId(hubId, itemReq.productId())
                        .orElseThrow(() -> new RuntimeException("No such product with a Id " +itemReq.productId()+ " is  in hub "+hubId));

                if (hubStock.getStock() < itemReq.quantity()){
                    throw new Exception("Insufficient Stock for a product " + hubStock.getProduct().getName()
                            + ". Requested: " + itemReq.quantity() +". Available:" + hubStock.getStock());

                }

                hubStock.setStock(hubStock.getStock() - itemReq.quantity());
                hubRepository.save(hubStock);

                double itemTotal = itemReq.unitPrice() * itemReq.quantity();
                grandTotal += itemTotal;


                OrderItems orderItems = OrderItems.builder().order(order)
                        .product(hubStock.getProduct())
                        .quantity(itemReq.quantity())
                        .priceAtPurchase(itemReq.unitPrice())
                        .build();

                order.getOrderItems().add(orderItems);



            }

            order.setTotalAmt(grandTotal);
            return orderRepository.save(order);

        }







}
