package com.murali.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murali.ProductService.model.ProductRequest;
import com.murali.ProductService.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest request){
		
		long productId=productService.addProduct(request);
		return new ResponseEntity<>(productId,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductRequest> Product(@PathVariable Long id){
		
		ProductRequest product=productService.getProduct(id);
		return new ResponseEntity<>(product,HttpStatus.OK);
		
	}
	
}
