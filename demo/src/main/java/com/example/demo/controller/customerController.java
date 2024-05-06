package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.customer;
import com.example.demo.service.customerService;

@RestController
public class customerController {

    @Autowired
    private customerService service;

    @PostMapping("/addcustomer")
    public customer addCustomer(@RequestBody customer custom){
        return service.saveCustomer(custom);
    }

    @GetMapping("/customers")
    public List<customer> findAllCustomers(){
        return service.getCustomers();
    }

    @GetMapping("/customer/{id}")
    public customer getCustomerById(@PathVariable long id){
        return service.getCustomerById(id);
    }

    @DeleteMapping("/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable long id){
        return service.deleteCustomer(id);
    }

    @PutMapping("/updatecustomer")
    public customer updatCustomer(@RequestBody customer custom){
        return service.updatCustomer(custom);
    }
}
