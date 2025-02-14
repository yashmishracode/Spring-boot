package com.yash.demo.dao;


import com.yash.demo.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
