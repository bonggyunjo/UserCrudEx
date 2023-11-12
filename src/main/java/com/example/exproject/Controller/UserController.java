package com.example.exproject.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    /*
    회원가입 페이지
    */
    @GetMapping("/signup")
    public String showSignUp() {
        return "/SignUp/SignUp";
    }


}