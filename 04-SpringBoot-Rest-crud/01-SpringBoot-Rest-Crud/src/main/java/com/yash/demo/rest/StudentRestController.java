package com.yash.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//define @postconstruct to load the student data ... only once!
	
	
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Yash","mishra"));
		theStudents.add(new Student("Sandeep","mishra"));
		theStudents.add(new Student("Anubhav","mishra"));
	}
	
	//Define Endpoints for "/student" - return a list of student
	
	@GetMapping("/students")
	public List<Student> getStudents(){
	return theStudents;
	
	}	
	
	//define endpoints or '/student/{studentId}' - return student at index
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		return theStudents.get(studentId);
	}
}
