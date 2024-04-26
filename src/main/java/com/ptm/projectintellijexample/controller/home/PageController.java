package com.ptm.projectintellijexample.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/contact")
    public String contact(){
        return "home/page/contact";
    }

    @GetMapping("/about")
    public String about(){
        return "home/page/about";
    }

    @GetMapping("/blogs")
    public String blogs(){
        return "home/page/blogs";
    }

    @GetMapping("/blog-detail")
    public String blogDetail(){
        return "home/page/blog-detail";
    }

    @GetMapping("/wishlist")
    public String wishlist(){
        return "home/page/wishlist";
    }

    @GetMapping("/privacy-policy")
    public String privacyPolicy(){
        return "home/page/privacy-policy";
    }

    @GetMapping("/terms-of-service")
    public String termsOfService(){
        return "home/page/terms-of-service";
    }

    @GetMapping("/page-not-found")
    public String pageNotFound(){
        return "home/page/page-not-found";
    }
}
