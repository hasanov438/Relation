package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private Long locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
}
