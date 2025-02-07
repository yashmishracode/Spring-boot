package com.yash.cruddemo.dao;


import java.util.List;

import com.yash.cruddemo.entity.Student;

public interface StudentDAO {
	 void save(Student theStudent);
	 Student findStudent(Integer id);
	 List<Student> findAll();
	 List<Student> findByLastName(String theLastName);
	

}
