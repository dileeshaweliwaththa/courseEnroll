package com.uwu.courseenroll;
import org.springframework.web.bind.annotation.GetMapping;

public class mainController {

    @GetMapping("")
    public String showHomePage(){
        System.out.println("Main Controller");
        return "index";
    }

}
