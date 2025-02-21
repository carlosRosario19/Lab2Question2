package com.centennial.devops.lab2question2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showWelcomePage(Model model){
        String name = "Carlos Rosario"; // Replace with your name
        LocalTime now = LocalTime.now();
        String greeting = (now.getHour() < 12) ? "Good morning" : "Good afternoon";
        model.addAttribute("greeting",greeting + " " + name + ", Welcome to COMP367");
        return "welcome";
    }
}
