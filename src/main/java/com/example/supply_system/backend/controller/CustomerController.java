package com.example.supply_system.backend.controller;


import com.example.supply_system.backend.entity.CustomerProfile;
import com.example.supply_system.backend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("api/v1/customers")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<CustomerProfile>> getAllCustomers(){

        return ResponseEntity.ok(customerService.getAllCustomers());

    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerProfile> getCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerProfile customer){
        try{
            CustomerProfile customerCreated = customerService.registerCustomer(customer);
            return new ResponseEntity<>(customerCreated, HttpStatus.CREATED);
        }
        catch(RuntimeException e){

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}