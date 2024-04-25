package com.ptm.projectintellijexample.controller.home;

import com.ptm.projectintellijexample.service.CategoryService;
import com.ptm.projectintellijexample.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping("")
    public String home(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            model.addAttribute("user", authentication.getName());
        }
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("t8products", productService.top8Products());
        model.addAttribute("newProduct", productService.newArrival());
        return "home/index";
    }

    @GetMapping("/cart")
    public String cart(){
        return "home/cart";
    }

    @GetMapping("/checkout")
    public String checkout(){
        return "home/checkout";
    }

    @GetMapping("/my-account")
    public String myAccount(){
        return "home/my-account";
    }




}
