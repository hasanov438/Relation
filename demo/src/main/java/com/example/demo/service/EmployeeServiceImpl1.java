package com.example.demo.service;

import com.example.demo.exception.EmployeeAlreadyExistsException;
import com.example.demo.exception.NoSuchElementException;
import com.example.demo.exception.NoSuchEmployeeExistsException;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepositoryImpl1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl1 implements EmployeeService {


    private EmployeeRepositoryImpl1 employeeRepository;

    @Autowired
    public EmployeeServiceImpl1(EmployeeRepositoryImpl1 employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public ResponseEntity<List<Employee>> insertEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeRepository.getEmployeeByID(employee.getEmployeeId());
        if (employee1 == null) {
            employeeRepository.insertEmployee(employee);
            log.info("Employee created");
            return new ResponseEntity<>(List.of(employee), HttpStatus.OK);
        } else {
            throw new EmployeeAlreadyExistsException("employee already exist");
        }
    }

    @Override
    public ResponseEntity<List<Employee>> updateWithId(Employee employee) {
        Employee employee1 = employeeRepository.getEmployeeByID(employee.getEmployeeId());
        if (employee1 != null) {
            employeeRepository.updateWithId(employee);
            log.info("Employee updated");
            return new ResponseEntity<>(List.of(employee), HttpStatus.ACCEPTED);
        } else {
            throw new NoSuchEmployeeExistsException("no such employee exist : " + List.of(employee));
        }
    }


    @Override
    public ResponseEntity<String> deleteWithId(Long employeeID) {
        Employee employee = employeeRepository.getEmployeeByID(employeeID);
        if (employee != null) {
            employeeRepository.deleteWithId(employeeID);
            log.info("Employee deleted");
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            throw new NoSuchElementException("There no such element id=" + employeeID);
        }
    }

    public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") Long id) {
        Employee employee = employeeRepository.getEmployeeByID(id);
        if (employee != null) {
            log.info("Employee by id = " + id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            throw new NoSuchElementException("no such element id=" + id);
        }
    }

    @Override
    public ResponseEntity<List<Department>> departmentList() {
        return new ResponseEntity<>(employeeRepository.departmentList(), HttpStatus.FOUND);
    }
}
