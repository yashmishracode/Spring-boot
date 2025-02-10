package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.*;

@RestController
public class DemoController {

	// define a private field for dependencies

	private Coach myCoach;

	// define a constructor for dependencies fir injections
	// Constructor injecti
	@Autowired
	public DemoController(Coach theCoach) {
		myCoach = theCoach;
	}

	@GetMapping("/workout")
	public String workout() {
		return myCoach.getDailyWorkout();
	}
}
