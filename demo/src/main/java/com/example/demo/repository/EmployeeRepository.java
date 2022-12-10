package com.example.demo.repository;


import com.example.demo.model.Department;
import com.example.demo.model.Employee;

import java.util.List;


public interface EmployeeRepository {
    public int insertEmployee(Employee employee);

    public void updateWithId(Employee employee);

    public void deleteWithId(Long employeeID) ;

    public List<Department> departmentList();
}
