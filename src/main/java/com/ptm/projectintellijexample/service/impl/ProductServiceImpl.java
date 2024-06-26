package com.ptm.projectintellijexample.service.impl;

import com.ptm.projectintellijexample.model.Product;
import com.ptm.projectintellijexample.repository.ProductRepository;
import com.ptm.projectintellijexample.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Boolean create(Product product) {
        try {
            this.productRepository.save(product);
            return true;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findById(Integer productId) {
        return this.productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + productId));
    }

    @Override
    public Boolean update(Product product) {
        try {
            this.productRepository.save(product);
            return true;
        }catch (Exception e){
           throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean delete(Integer productId){
        try{
            this.productRepository.delete(findById(productId));
            return true;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> top8Products() {
        return this.productRepository.findAll()
                .stream().limit(8).collect(Collectors.toList());
    }

    @Override
    public List<Product> newArrival() {
        return this.productRepository.findTop5ByOrderByCreateDateDesc();

    }

    @Override
    public Page<Product> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo-1, 6);
        return this.productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findProductsByCategoryIdExcludingProductId(Integer categoryId, Integer productId) {
        return this.productRepository.findProductsByCategoryIdExcludingProductId(categoryId, productId);
    }

}
