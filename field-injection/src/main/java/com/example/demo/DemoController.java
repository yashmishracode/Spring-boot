package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DemoController {

	// define a private field for dependencies
	@Autowired
	private Coach myCoach;

	// no need for constructors and setters

	@GetMapping("/workout")
	public String workout() {
		return myCoach.getDailyWorkout();
	}
}
