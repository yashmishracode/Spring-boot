package com.yash.demo.rest;


import com.yash.demo.Entity.Employee;
import com.yash.demo.dao.EmployeeDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeDAO employeeDAO;

    //quick and dirty : inject employee dao
    public EmployeeController(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
