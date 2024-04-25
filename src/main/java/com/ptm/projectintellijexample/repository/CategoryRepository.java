package com.ptm.projectintellijexample.repository;

import com.ptm.projectintellijexample.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public List<Category> findByName(String name);

}
