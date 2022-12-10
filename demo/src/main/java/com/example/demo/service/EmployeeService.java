package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    ResponseEntity<List<Employee>> insertEmployee(Employee employee);

    ResponseEntity<List<Employee>> updateWithId(Employee employeeId);

    ResponseEntity<List<Department>> departmentList();

    ResponseEntity<String> deleteWithId(Long employeeID);

}
