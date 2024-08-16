package com.murali.ProductService.service;

import com.murali.ProductService.model.ProductRequest;

public interface ProductService {

	long addProduct(ProductRequest request);

	ProductRequest getProduct(Long id);

}
