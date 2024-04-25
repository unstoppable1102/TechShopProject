package com.ptm.projectintellijexample.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CustomerController {
    @GetMapping("/logon")
    public String logon(){
        return "admin/logon";
    }

    @PostMapping("/logon")
    public String processLogon(){
        return "redirect:/admin/";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "redirect:/admin/logon";
    }
}
