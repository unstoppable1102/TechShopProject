package com.ptm.projectintellijexample.service.impl;

import com.ptm.projectintellijexample.model.Brand;
import com.ptm.projectintellijexample.repository.BrandRepository;
import com.ptm.projectintellijexample.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getAll() {
        return this.brandRepository.findAll();
    }

    @Override
    public Boolean create(Brand brand) {
        try{
            this.brandRepository.save(brand);
            return  true;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Brand findById(Integer brandId) {
        return this.brandRepository.findById(brandId).get();
    }

    @Override
    public Boolean update(Brand brand) {
        try {
            this.brandRepository.save(brand);
            return true;

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Boolean delete(Integer brandId) {
        try {
            this.brandRepository.deleteById(brandId);
            return true;

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
