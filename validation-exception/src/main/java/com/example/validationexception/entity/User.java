package com.example.validationexception.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER")
@Data
@AllArgsConstructor(staticName= "build")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Integer userId;
    private String name;
    private String emailID;
    private String gender;
}
