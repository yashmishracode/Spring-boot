package com.example.demo.common;

public class SwimCoach implements Coach {
    
    public SwimCoach() {
        System.out.println("the Constructor : "+getClass().getSimpleName());
    }
    

    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up.";
    }

    
    
}
