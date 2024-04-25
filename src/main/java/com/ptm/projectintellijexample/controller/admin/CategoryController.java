package com.ptm.projectintellijexample.controller.admin;

import com.ptm.projectintellijexample.model.Category;
import com.ptm.projectintellijexample.service.CategoryService;
import com.ptm.projectintellijexample.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final StorageService storageService;


    @GetMapping("/category")
    public String index(Model model){
        model.addAttribute("categories", categoryService.getAll());
        return "admin/category/index";
    }

    @GetMapping("/category-add")
    public String add(Model model){
        model.addAttribute("category", new Category());
        return "admin/category/add";
    }

    @PostMapping("/category-add")
    public String save(@ModelAttribute Category category, @RequestParam("file") MultipartFile file,Model model){
        //upload file
        this.storageService.store(file);
        String fileName = file.getOriginalFilename();
        category.setImage(fileName);
        if(this.categoryService.create(category)){
            model.addAttribute("category", category);
            return "redirect:/admin/category";
        }else {
            return "admin/category/add";
        }
    }

    @GetMapping("/category-edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        model.addAttribute("category", categoryService.findById(id));
        return "admin/category/edit";
    }

    @PostMapping("/category-edit")
    public String update(@ModelAttribute("category") Category category,  @RequestParam("file") MultipartFile file){
        if(file != null && !file.isEmpty()) {
            this.storageService.store(file);
            String fileName = file.getOriginalFilename();
            category.setImage(fileName);
        }else {
            var categoryOld = categoryService.findById(category.getId());
            category.setImage(categoryOld.getImage());
        }

        if(this.categoryService.create(category)){
            return "redirect:/admin/category";
        }else {
            return "admin/category/edit";
        }
    }

    @GetMapping("/category-delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        if(this.categoryService.delete(id)){
            return "redirect:/admin/category";
        }else {
            return "admin/category/index";
        }
    }

}
