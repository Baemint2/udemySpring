package com.moz1mozi.springcoredemo.config;

import com.moz1mozi.springcoredemo.common.Coach;
import com.moz1mozi.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
