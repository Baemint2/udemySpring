package com.moz1mozi.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // need a controller method to read form data and
    // add data to the model

    @GetMapping("/processFormVersionTwo")
    public String letsShoutDude(@RequestParam("studentName") String theName, Model model) {

        // read the request parameter from the HTML form
        //convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo ! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
