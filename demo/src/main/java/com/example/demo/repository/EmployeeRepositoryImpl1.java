package com.example.demo.repository;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepositoryImpl1 implements EmployeeRepository {


    private DataSource dataSource;
    private SimpleJdbcInsert simpleJdbcInsert;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public EmployeeRepositoryImpl1(DataSource dataSource) {
        this.dataSource = dataSource;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("employees");
    }


    @Override
    public void deleteWithId(Long employeeID) {
        jdbcTemplate.update("DELETE from employees where employee_id=? ", employeeID);
    }

    @Override
    public void updateWithId(Employee employee) {
        jdbcTemplate.update("update employees " +
                        "set employee_id=?,first_name=?,last_name=?,email=?,phone_number=?,hire_date=?,job_id=?,salary=?,manager_id=?,department_id=? where employee_id=?", employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(),
                employee.getPhoneNumber(), employee.getHireDate(), employee.getJobId(), employee.getSalary(), employee.getManagerID(), employee.getDepartmentId());
    }

    @Override
    public int insertEmployee(Employee employee) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("employee_id", employee.getEmployeeId());
        parameters.put("first_name", employee.getFirstName());
        parameters.put("last_name", employee.getLastName());
        parameters.put("email", employee.getEmail());
        parameters.put("phone_number", employee.getPhoneNumber());
        parameters.put("hire_date", employee.getHireDate());
        parameters.put("job_id", employee.getJobId());
        parameters.put("salary", employee.getSalary());
        parameters.put("manager_id", employee.getManagerID());
        parameters.put("department_id", employee.getDepartmentId());
        parameters.put("image_url",employee.getImageUrl());
        return simpleJdbcInsert.execute(parameters);
    }

    public Employee getEmployeeByID(Long id) {
        try {
            Employee employee = jdbcTemplate.queryForObject("select * from employees where employee_id=?", BeanPropertyRowMapper.newInstance(Employee.class), id);
            return employee;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Department> departmentList() {
        return jdbcTemplate.query("select department_id,department_name,street_address,postal_code,city,state_province" + " from departments inner join locations on departments.location_id=locations.location_id", BeanPropertyRowMapper.newInstance(Department.class));
    }



//    public int  saveAll(List<Department>departmentList) {
//    return jdbcTemplate.batchUpdate(
//            departmentList,"insert into departments(department_id,department_name,location_id) + values (?,?,?)",
//            departmentList,100,(PreparedStatement ps , Department department) -> {
//                ps.setLong(1,department.getDepartmentId());
//            });
//    }

}

