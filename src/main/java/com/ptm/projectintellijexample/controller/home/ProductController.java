package com.ptm.projectintellijexample.controller.home;

import com.ptm.projectintellijexample.model.Product;
import com.ptm.projectintellijexample.service.CategoryService;
import com.ptm.projectintellijexample.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller(value = "ProductControllerOfHome")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("products", productService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        return "home/product/shop";
    }

    @GetMapping("product-detail/{productId}")
    public String productDetail(@PathVariable Integer productId, Model model){
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAll());
        if (product != null && product.getCategory() != null){
            model.addAttribute("pExcludepId", productService.getProductsByCategoryExcludingProduct(product.getCategoryId(), productId));
        }
        return "home/product-detail";
    }
}
