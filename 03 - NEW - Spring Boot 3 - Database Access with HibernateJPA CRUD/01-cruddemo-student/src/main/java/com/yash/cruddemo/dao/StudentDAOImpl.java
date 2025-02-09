package com.yash.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yash.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


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
	
	@Override
	public List<Student> findAll(){
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student ",Student.class);
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		//CREATE QUERY
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student where lastName =:theData",Student.class);
		
		//SET QUERY PARAMETER
		theQuery.setParameter("theData", theLastName);
		
		//RETURN QUERY PARAMETER
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Student theStudent =entityManager.find(Student.class, id);
		entityManager.remove(theStudent);
	}
	
	
}
