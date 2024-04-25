package com.ptm.projectintellijexample.service.impl;

import com.ptm.projectintellijexample.model.Category;
import com.ptm.projectintellijexample.repository.CategoryRepository;
import com.ptm.projectintellijexample.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Boolean create(Category category) {
        try{
            this.categoryRepository.save(category);
            return  true;
        }catch (Exception e){
           throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Category findById(Integer id) {
        return this.categoryRepository.findById(id).get();
    }

    @Override
    public Boolean update(Category category) {
        try {
            this.categoryRepository.save(category);
            return true;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean delete(Integer id) {
       try{
           this.categoryRepository.deleteById(id);
           return true;
       }catch (Exception e){
           e.printStackTrace();
       }
        return false;
    }
    @Override
    public List<Category> searchCategory(String keyword) {
        return this.categoryRepository.findByName(keyword);
    }
}
