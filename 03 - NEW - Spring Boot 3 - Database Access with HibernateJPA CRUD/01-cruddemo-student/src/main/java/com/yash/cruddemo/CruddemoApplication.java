package com.yash.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.yash.cruddemo.dao.StudentDAO;
import com.yash.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner ->{
//			CreateStudent(studentDAO);	
			CreateMultipleStudent(studentDAO);
			};
	}
	
	private void CreateMultipleStudent(StudentDAO studentDAO) {
		// Create student object
		System.out.println("Createing new student object");
		Student tempStudent1 = new Student("Sandeep", "Mishra", "sandeep@luv2code.com");
		Student tempStudent2 = new Student("Umesh", "Kumar", "umesh@luv2code.com");
		Student tempStudent3 = new Student("Abhay", "Tiwari", "abhay@luv2code.com");
		
		// Save the Student object
		
		System.out.println("Saving the Student");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	

//	public void CreateStudent(StudentDAO studentDAO) {
//		//Create Student Object
//		System.out.println("Createing new student object");
//		Student tempStudent = new Student("yash", "mishra", "yash@luv2code.com");
//		
//		// Save the Student object
//		
//		System.out.println("Saving the Student");
//		studentDAO.save(tempStudent);
		
		//Displaying id of the student
		System.out.println("Saved Student.Generate id : "+ tempStudent1.getId());
		
		
		//Retrieve Students Based on id: Primary Key
		
		System.out.println("In Retriving Student with ID : " + tempStudent1.getId());
		Student myStudent = studentDAO.findStudent(tempStudent1.getId());
		System.out.println("Found thee Student :" + myStudent);
		
		
	}

}
