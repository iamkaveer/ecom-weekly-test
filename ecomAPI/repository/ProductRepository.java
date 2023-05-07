package com.ecomapi.ecomAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomapi.ecomAPI.model.Product;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(String category);

    @Query(value = "select * from tbl_product where product_id =:id",nativeQuery = true)
    Product getProductById(Integer id);
}
