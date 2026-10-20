package com.example.supply_system.backend.service;

import com.example.supply_system.backend.entity.CustomerProfile;
import com.example.supply_system.backend.repository.CustomerProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerProfileRepository customerRepository;

    public List<CustomerProfile> getAllCustomers() {
        return customerRepository.findAll();

    }

    public CustomerProfile getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer Not Found With Customer_ID" + customerId));
    }


    public CustomerProfile registerCustomer(CustomerProfile customer) {

        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new RuntimeException("Email already exists:"+customer.getEmail());

        }
        return customerRepository.save(customer);
    }
}
