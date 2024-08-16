package com.murali.ProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murali.ProductService.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
