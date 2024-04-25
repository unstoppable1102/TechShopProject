package com.ptm.projectintellijexample.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/sign-up")
    public String signUp(){
        return "home/sign-up";
    }

    @GetMapping("/login")
    public String loginHome(){
        return "home/sign-in";
    }

    @PostMapping("/login")
    public String processLogin(){

        return "redirect:/";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(){
        return "home/forgot-password";
    }

    @GetMapping("/reset-password")
    public String resetPassword(){
        return "home/reset-password";
    }
}
