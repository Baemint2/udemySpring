package com.moz1mozi.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {

        return "home";
    }

    // add a request mapping for leaders
    @GetMapping("/leaders")
    public String showLeader() {

        return "leaders";
    }

    @GetMapping("/systems")
    public String showSystems() {

        return "systems";
    }
}