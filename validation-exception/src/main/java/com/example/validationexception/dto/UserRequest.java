package com.example.validationexception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName= "build")
@NoArgsConstructor
public class UserRequest {

    private String name;
    private String emailID;
    private String gender;
}
