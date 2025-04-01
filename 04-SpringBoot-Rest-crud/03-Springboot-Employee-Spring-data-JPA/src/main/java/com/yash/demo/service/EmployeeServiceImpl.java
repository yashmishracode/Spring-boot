package com.yash.demo.service;

import com.yash.demo.DAO.EmployeeRepository;
import com.yash.demo.Entity.Employee;
import com.yash.demo.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
    	Optional<Employee> result = employeeRepository.findById(theId);  //<Optional> Different Pattern instead of having to check for null;
    	
    	Employee thEmployee = null;
    	
    	if(result.isPresent()) {
    		thEmployee = result.get();
    	}
    	else {
    		// we didn't find the employee
    		throw new RuntimeException("Did not Find employee id - " + theId);
    	}
    	
    	return thEmployee;
    	
    }


    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }


    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
