package com.moz1mozi.springcoredemo.rest;

import com.moz1mozi.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;


    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = theCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
