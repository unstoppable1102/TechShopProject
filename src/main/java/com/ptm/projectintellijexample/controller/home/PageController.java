package com.ptm.projectintellijexample.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/contact")
    public String contact(){
        return "home/contact";
    }

    @GetMapping("/about")
    public String about(){
        return "home/about";
    }

    @GetMapping("/blogs")
    public String blogs(){
        return "home/blogs";
    }

    @GetMapping("/blog-detail")
    public String blogDetail(){
        return "home/blog-detail";
    }

    @GetMapping("/wishlist")
    public String wishlist(){
        return "home/wishlist";
    }

    @GetMapping("/privacy-policy")
    public String privacyPolicy(){
        return "home/privacy-policy";
    }

    @GetMapping("/terms-of-service")
    public String termsOfService(){
        return "home/terms-of-service";
    }

    @GetMapping("/page-not-found")
    public String pageNotFound(){
        return "home/page-not-found";
    }
}
