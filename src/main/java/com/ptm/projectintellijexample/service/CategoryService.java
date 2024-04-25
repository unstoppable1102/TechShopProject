package com.ptm.projectintellijexample.service;

import com.ptm.projectintellijexample.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService extends GenericService<Category,Integer>{
    List<Category> searchCategory(String keyword);
}
