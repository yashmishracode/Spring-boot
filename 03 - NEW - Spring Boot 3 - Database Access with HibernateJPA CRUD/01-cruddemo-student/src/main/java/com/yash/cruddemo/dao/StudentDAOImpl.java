package com.yash.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yash.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;


@Repository
public class StudentDAOImpl implements StudentDAO{
	
	//Define fields for entity manager
	private EntityManager entityManager;
	
	//inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager thEntityManager) {
		entityManager = thEntityManager;
	}
	
	// Implement save method 
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}
	
	@Override
	public Student findStudent(Integer id) {
		return entityManager.find(Student.class, id);
		
	}

}
