package com.example.multidataset1.model;

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
@Table(name = "User_TB", schema = "datasource1")
public class User {

    @Id
    private Integer id;
    private String name;
    private String email;
    private long num;
    private Integer books;
}
