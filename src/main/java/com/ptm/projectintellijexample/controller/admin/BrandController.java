package com.ptm.projectintellijexample.controller.admin;

import com.ptm.projectintellijexample.model.Brand;
import com.ptm.projectintellijexample.service.BrandService;
import com.ptm.projectintellijexample.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;
    private final StorageService storageService;

    @GetMapping("/brand")
    public String index(Model model){
        model.addAttribute("brands", brandService.getAll());
        return "admin/brand/index";
    }

    @GetMapping("/brand-add")
    public String add(Model model){
        model.addAttribute("brand", new Brand());
        return"admin/brand/add";
    }

    @PostMapping("/brand-add")
    public String save(@ModelAttribute Brand brand, @RequestParam("logoImage") MultipartFile file, Model model){
        //upload file
        this.storageService.store(file);
        String fileName = file.getOriginalFilename();
        brand.setLogo(fileName);

        if(this.brandService.create(brand)){
            model.addAttribute("brand", brand);
            model.addAttribute("msg", "Add successful!");
            return "redirect:/admin/brand";
        }else {
            model.addAttribute("msg", "Add failed!");
            return "admin/brand/add";
        }
    }

    @GetMapping("/brand-edit/{brandId}")
    public String editBrand(Model model, @PathVariable Integer brandId){
        model.addAttribute("brand", brandService.findById(brandId));
        return "admin/brand/edit";
    }

    @PostMapping("/brand-edit")
    public String update(@ModelAttribute Brand brand, @RequestParam("logoImage") MultipartFile file, Model model){

        if(file != null && !file.isEmpty()) {
            this.storageService.store(file);
            String fileName = file.getOriginalFilename();
            brand.setLogo(fileName);
        }else {
            var brandOld = brandService.findById(brand.getBrandId());
            brand.setLogo(brandOld.getLogo());
        }
        if (this.brandService.update(brand)){
            model.addAttribute("msg", "Update successful!");
            return "redirect:/admin/brand";
        }else {
            model.addAttribute("msg", "Update failed!");
            return "admin/brand/edit";
        }
    }

    @GetMapping("/brand-delete/{brandId}")
    public String delete(@PathVariable Integer brandId, Model model){
        if(this.brandService.delete(brandId)){
            model.addAttribute("msg", "Delete successful!");
            return "redirect:/admin/brand";
        }else {
            model.addAttribute("msg", "Delete failed!");
            return "admin/brand/index";
        }
    }
}
