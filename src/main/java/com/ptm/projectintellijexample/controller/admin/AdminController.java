package com.ptm.projectintellijexample.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("")
    public String index(){
      return "redirect:/admin/";
    }

    @RequestMapping("/")
    public String admin(){
        return "admin/index";
    }

    @GetMapping("/sales")
    public String adminSaleDashboard(){
        return "admin/sales/dashboard";
    }
    @GetMapping("/order-detail")
    public String orderDetailList(){
        return "admin/order-detail/index";
    }
    @GetMapping("/crm-dashboard")
    public String crmDashboard(){
        return "admin/crm/dashboard";
    }
    @GetMapping("/crm-calendar")
        public String crmCalendar(){
            return "admin/crm/calendar";
    }

    @GetMapping("/crm-customer")
    public String crmCustomer(){
        return "admin/crm/customer";
    }

    @GetMapping("/crm-customer-detail")
    public String crmCustomerDetail(){
        return "admin/crm/customer-detail";
    }
    @GetMapping("/crm-mail")
    public String crmMail(){
        return "admin/crm/mail";
    }

    @GetMapping("/sign-up")
    public String signUp(){
        return "admin/sign-up";
    }

    @GetMapping("/forgot-password")
    public String forgotPassWord(){
        return "admin/forgot-password";
    }

    @GetMapping("/reset-password")
    public String resetPassword(){
        return "admin/reset-password";
    }

    @GetMapping("/help-center")
    public String helpCenter(){
        return "admin/knowledgeBase/help-center";
    }

    @GetMapping("/account-settings")
    public String accountSettings(){
        return "admin/account/settings";
    }

    @GetMapping("/account-checkout")
    public String accountCheckout(){
        return "admin/account/checkout";
    }

    @GetMapping("/account-activity-log")
    public String activityLog(){
        return "admin/account/activity-log";
    }

    @GetMapping("/account-information")
    public String accountInfo(){
        return "admin/account/information";
    }
}
