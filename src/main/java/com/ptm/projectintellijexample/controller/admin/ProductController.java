package com.ptm.projectintellijexample.controller.admin;


import com.ptm.projectintellijexample.model.Product;
import com.ptm.projectintellijexample.service.CategoryService;
import com.ptm.projectintellijexample.service.ProductService;
import com.ptm.projectintellijexample.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.time.LocalDate;

@Controller(value ="ProductControllerOfAdmin")
@RequestMapping("/admin")
@RequiredArgsConstructor
public class ProductController {

    private final CategoryService categoryService;
    private final StorageService storageService;
    private final ProductService productService;

    @GetMapping("/product")
    public String index(Model model, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo){
        model.addAttribute("categories", categoryService.getAll());
        Page<Product> products = productService.getAll(pageNo);
        model.addAttribute("totalPage", products.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("products", products);
        return "admin/product/index";
    }

    @GetMapping("/product-add")
    public String add(Model model){
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("product", new Product());
        return "admin/product/add";
    }

    @PostMapping("/product-add")
    public String save(@ModelAttribute Product product, @RequestParam("file") MultipartFile file, Model model){
        //upload file
        this.storageService.store(file);
        String fileName = file.getOriginalFilename();
        product.setImage(fileName);
        product.setCreateDate(Date.valueOf(LocalDate.now()));
        if(this.productService.create(product)){
            model.addAttribute("product", product);
            return"redirect:/admin/product";
        }
       return "admin/product/add";
    }

    @GetMapping("/product-edit/{productId}")
    public String editProduct(Model model, @PathVariable("productId") Integer productId){
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("product", productService.findById(productId));
        return "admin/product/edit";
    }

    @PostMapping("/product-edit")
    public String update(@ModelAttribute("product") Product product, @RequestParam("file") MultipartFile file){

        if(file != null && !file.isEmpty()) {
            this.storageService.store(file);
            String fileName = file.getOriginalFilename();
            product.setImage(fileName);
        }else {
            var productOld = productService.findById(product.getProductId());
            product.setImage(productOld.getImage());
        }
        product.setCreateDate(Date.valueOf(LocalDate.now()));
        if (this.productService.update(product)){
            return "redirect:/admin/product";
        }
        return "admin/product/edit";
    }

    @GetMapping("/product-delete/{productId}")
    public String delete(Model model, @PathVariable("productId") Integer productId){
        if(this.productService.delete(productId)){
            model.addAttribute("msg", "Xoá thành công");
            return "redirect:/admin/product";
        }else {
            model.addAttribute("msg", "Xoá thất bại");
            return "admin/product/index";
        }
    }
}
