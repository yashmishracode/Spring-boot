package com.example.demo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkout() {

		return "10 Push-ups now and 1 km run";
	}

}
