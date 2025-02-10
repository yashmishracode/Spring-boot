package com.yash.cruddemo;

import java.util.List;

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
//			CreateMultipleStudent(studentDAO);
//			QueryForStudent(studentDAO);
//			ReadStudent(studentDAO);
//			QueryForStudentByLastName(studentDAO);
//			UpdateStrudent(studentDAO);
//			DeleteStudent(studentDAO);
			};
	}
	
//			FOR CREATING MULTIPLE OF USERS AT ONCE

	private void DeleteStudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("Delete Student with id :" + studentId);
		studentDAO.delete(studentId);
		
	}

	private void UpdateStrudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("Getting Student wioth Id :"+ studentId);
		Student myStudent = studentDAO.findStudent(studentId);
		System.out.println("Updating Student");
		myStudent.setFirstName("Yash");
		studentDAO.update(myStudent);
		System.out.println("Updated Student :" +myStudent);
		
	}

	private void QueryForStudentByLastName(StudentDAO studentDAO) {
		//GET A LIST OF STUDENT
		List<Student> theStudents = studentDAO.findByLastName("Mishra");
		//DISPLAY LIST OF STUDENT
		for (Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
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
	
	//Displaying id of the student
		System.out.println("Saved Student.Generate id : "+ tempStudent1.getId());
		System.out.println("Saved Student.Generate id : "+ tempStudent2.getId());
		System.out.println("Saved Student.Generate id : "+ tempStudent3.getId());

		
	}

	//     FOR CREAATING SINGLE USER

		public void CreateStudent(StudentDAO studentDAO) {
			//Create Student Object
			System.out.println("Createing new student object");
			Student tempStudent = new Student("yash", "mishra", "yash@luv2code.com");
//		
//		// Save the Student object
//		
			System.out.println("Saving the Student");
			studentDAO.save(tempStudent);
		
		//Displaying id of the student
		System.out.println("Saved Student.Generate id : "+ tempStudent.getId());	
		
	}
		
		// FOR SEARCHING AND SORTING
		
		private void QueryForStudent(StudentDAO studentDAO) {
			// Searching from database 
			
					List<Student> theStudents = studentDAO.findAll();
					for (Student tempStudent : theStudents) {
						System.out.println(tempStudent);
					}
					
			
		}
		
		// FOR READING THE USER JUST CREATED

		private void ReadStudent(StudentDAO studentDAO) {
			//Create Student Object
			System.out.println("Createing new student object");
			Student tempStudent = new Student("yash", "mishra", "yash@luv2code.com");
		
		// Save the Student object
		
			System.out.println("Saving the Student");
			studentDAO.save(tempStudent);
		
		//Displaying id of the student
		System.out.println("Saved Student.Generate id : "+ tempStudent.getId());
			
			//Retrieve Students Based on id: Primary Key
			
					System.out.println("In Retriving Student with ID : " + tempStudent.getId());
					Student myStudent = studentDAO.findStudent(tempStudent.getId());
					System.out.println("Found thee Student :" + myStudent);
			
		}

}
