package com.ptm.projectintellijexample.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CustomerController {
    @RequestMapping("/logon")
    public String logon(){
        return "admin/logon";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "redirect:/admin/logon";
    }
}
