package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.customer;
import com.example.demo.repository.customerRepositor;

@Service
public class customerService {

    @Autowired
    private customerRepositor repo;

    public customer saveCustomer(customer cust){
        return repo.save(cust);
    }

    public customer getCustomerById(long id){
        return repo.findById(id).orElse(null);
    }

    public List<customer> getCustomers(){
        return (List<customer>) repo.findAll();
    }

    public String deleteCustomer(long id){
        repo.deleteById(id);
        return "produce remover !!"+id;
    }

    public customer updatCustomer(customer custom){
        customer existingCustomer = repo.findById(custom.getId()).orElse(null);
        existingCustomer.setName(custom.getName());
        existingCustomer.setAccountNumber(custom.getAccountNumber());
        existingCustomer.setType(custom.getType());
        existingCustomer.setBalance(custom.getBalance());
        return repo.save(existingCustomer);
    }

}
    