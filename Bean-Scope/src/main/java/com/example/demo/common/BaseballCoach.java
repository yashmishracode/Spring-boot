package com.example.demo.common;

// import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
// import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return "Spend 30 minuts in batting practice";
    }

    
}
