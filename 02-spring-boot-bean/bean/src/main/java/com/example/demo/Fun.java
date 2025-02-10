package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Fun {
	
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	
	
	
	@GetMapping("/")
	public String hello() {
		return "Yash";
	}
	
	
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	
	//make exposing end point for this value
	
	@GetMapping("/team")
	public String team() {
		return "Coach Name is :"+ coachName + ", and team name is :"+teamName;
	}

}
