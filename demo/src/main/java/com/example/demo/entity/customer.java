package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class customer {

    @Id
    private long id;
    private String name;

    @Column(name = "number")
    private long accountNumber;

    @Column(name = "type")
    private String type;
    private long balance;
}
