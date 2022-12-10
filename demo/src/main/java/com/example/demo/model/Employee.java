package com.example.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    @ApiModelProperty(notes = "Employee ID", example = "1",
            required = true)
    private Long employeeId;
    @ApiModelProperty(notes = "Employee Name", example = "Husein", required = true)
    private String firstName;
    @ApiModelProperty(notes = "Employee LastName", example = "Hasan", required = true)
    private String lastName;
    @ApiModelProperty(notes = "Employee Email", example = "hasanov.850047@gmail.com", required = true)
    private String email;
    private String phoneNumber;
    private Date hireDate;
    @ApiModelProperty(example = "12")
    private Long jobId;
    private Integer salary;
    @ApiModelProperty(example = "100")
    private Long managerID;
    @ApiModelProperty(example = "10")
    private Long departmentId;
    private String imageUrl;

}


