package com.yash.demo.DAO;

import com.yash.demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {

    //that's it!, no need to write any code here
}
