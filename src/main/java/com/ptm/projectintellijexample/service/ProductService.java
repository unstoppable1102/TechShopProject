package com.ptm.projectintellijexample.service;

import com.ptm.projectintellijexample.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService extends GenericService<Product,Integer>{
    List<Product> top8Products();
    List<Product> newArrival();
    List<Product> getProductsByCategoryExcludingProduct(Integer categoryId, Integer productId);
    Page<Product> getAll(Integer pageNo);

}
