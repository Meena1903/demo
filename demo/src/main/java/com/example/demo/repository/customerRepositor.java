package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.customer;

@Repository
public interface customerRepositor extends JpaRepository<customer, Long> {

}
