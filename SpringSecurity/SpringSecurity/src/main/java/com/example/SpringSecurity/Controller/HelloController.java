package com.example.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/Hello")
    public String Hello(){
        return "hello world";
    }
    @GetMapping("/")
    public String Home(){
        return "Welcome";
    }
    @GetMapping("/aboutus")
    public String Aboutus(){
        return "about us ";
    }
}
