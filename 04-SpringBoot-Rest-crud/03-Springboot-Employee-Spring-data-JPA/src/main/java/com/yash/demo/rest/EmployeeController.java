package com.yash.demo.rest;


import com.yash.demo.Entity.Employee;
import com.yash.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    //quick and dirty : inject employee dao
    public EmployeeController(EmployeeService theEmployeeservice){
        employeeService = theEmployeeservice;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //add mapping for get a single employee by id;
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null){
            throw new RuntimeException("Employee not found by id -"+employeeId);
        }
        return theEmployee;
    }

    //Adding Mapping for POST/employees - add bew employee
    @PostMapping("/employees")
    public Employee addEmployees(@RequestBody Employee theEmployee){

        //also just in case they pass as id in JSON ... set id to 0
        //this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return  dbEmployee;
    }

    //add mapping for PUT / employee -update existing employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    //add mapping for DELETE /employees/{employeeId} - Delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        //throw exception if null
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found -"+ employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted Employee id -" + employeeId;
    }
}
