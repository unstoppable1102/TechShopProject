package com.ptm.projectintellijexample.service;

import com.ptm.projectintellijexample.model.Category;

import java.util.List;

public interface GenericService <T,K>{
    List<T> getAll();
    T findById(K id);
    Boolean create(T obj);
    Boolean update(T obj);
    Boolean delete(K id);
}
