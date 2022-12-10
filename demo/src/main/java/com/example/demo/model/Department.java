package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Department {
    private Long departmentId;
    private String departmentName;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;

}

