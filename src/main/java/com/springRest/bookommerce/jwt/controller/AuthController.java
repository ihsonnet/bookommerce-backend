package com.springRest.bookommerce.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/auth/")
public class AuthController {

    @GetMapping("/signup")
    public String signUp(){
        return "Signup page";
    }
}
