package com.ptm.projectintellijexample.repository;
import com.ptm.projectintellijexample.model.Category;
import com.ptm.projectintellijexample.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p WHERE p.productName like %?1%")
    List<Product> findByProductName(String searchName);
    List<Product> findTop5ByOrderByCreateDateDesc();
    @Query("SELECT p FROM Product p WHERE p.categoryId = :categoryId AND p.productId <> :productId")
    List<Product> findProductsByCategoryIdExcludingProductId(Integer categoryId, Integer productId);


}
