package com.example.ratings.repository;

import java.util.List;

public interface IRepository<T,K> {
    T save(K id,T entity);
    T save(T entity);
    T findById(K id);
    List<T> findAll();
    T deleteById(K id);


}
