package com.murali.ProductService.model;

import lombok.Data;

@Data
public class ProductRequest {
	
	private String ProductName;
	private long price;
	private long quantity;

}
