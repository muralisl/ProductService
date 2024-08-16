package com.murali.ProductService.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murali.ProductService.entity.Product;
import com.murali.ProductService.exception.ProductServiceCustomException;
import com.murali.ProductService.model.ProductRequest;
import com.murali.ProductService.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public long addProduct(ProductRequest request) {
		log.info("product add logic");

		Product product = Product.builder().productName(request.getProductName()).quantity(request.getQuantity())
				.price(request.getPrice()).build();
		productRepository.save(product);
		return product.getProductId();
	}

	@Override
	public ProductRequest getProduct(Long id) {
		log.info("get product");
		Product p = productRepository.findById(id).orElseThrow(()->new ProductServiceCustomException("Product with the given id is not found","PRODUCT_NOT_FOUND"));
		ProductRequest pr = new ProductRequest();
		BeanUtils.copyProperties(p, pr);
		return pr;

	}

}
