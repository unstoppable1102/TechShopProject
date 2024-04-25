package com.ptm.projectintellijexample.repository;
import com.ptm.projectintellijexample.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p WHERE p.productName like %?1%")
    List<Product> findByProductName(String searchName);

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId AND p.productId != :productId")
    List<Product> findByCategoryExcludingProduct(@Param("categoryId") Integer categoryId, @Param("productId") Integer productId);
    List<Product> findTop5ByOrderByCreateDateDesc();


}
