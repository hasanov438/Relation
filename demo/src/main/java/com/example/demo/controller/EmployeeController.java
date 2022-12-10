package com.example.demo.controller;

import com.example.demo.files.FileService;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepositoryImpl1;
import com.example.demo.service.EmployeeServiceImpl1;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeServiceImpl1 employeeService;
    @Autowired
    private EmployeeRepositoryImpl1 employeeRep;
    @Autowired
    private FileService fileService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl1 employeeService) {
        this.employeeService = employeeService;
    }


    @ApiOperation(value = "Create employee", notes = "Create employee with requestBody")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Employee created"), @ApiResponse(code = 404, message = "Not found -The employee ")})
    @PostMapping("/employees")
    public ResponseEntity<List<Employee>> createEmployee(@RequestBody Employee employee) {
        return employeeService.insertEmployee(employee);
    }

    @ApiOperation(value = "Update employee", notes = "Update employee with requestBody")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Updated"), @ApiResponse(code = 404, message = "Not found -The employeeID ")})
    @PutMapping("/update")
    public ResponseEntity<List<Employee>> updateWithId(@RequestBody Employee employee) {
        return employeeService.updateWithId(employee);
    }

    @ApiOperation(value = "Delete employee", notes = "Delete employee with employeeID")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Deleted"), @ApiResponse(code = 404, message = "Not found the employeeID")})
    @DeleteMapping("/delete/{employeeID}")
    public ResponseEntity<String> deleteWithId(@PathVariable("employeeID") @ApiParam(name = "employeeID", value = "employeeId", example = "1") Long employeeID) throws SQLException {
        return employeeService.deleteWithId(employeeID);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) {
        return employeeService.getEmployeeByID(id);
    }

    @GetMapping("/departments/all")
    public ResponseEntity<List<Department>> getAllDepartments() {
        return employeeService.departmentList();
    }




}
