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
			CreateStudent(studentDAO);		};
	}
	
	public void CreateStudent(StudentDAO studentDAO) {
		//Create Student Object
		System.out.println("Createing new student object");
		Student tempStudent = new Student("yash", "mishra", "yash@luv2code.com");
		
		// Save the Student object
		
		System.out.println("Saving the Student");
		studentDAO.save(tempStudent);
		
		//Displaying id of the student
		System.out.println("Saved Student.Generate id : "+ tempStudent.getId());
		
	}

}
