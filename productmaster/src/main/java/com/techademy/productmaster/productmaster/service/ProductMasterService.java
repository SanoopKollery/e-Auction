package com.techademy.productmaster.productmaster.service;

import org.springframework.http.ResponseEntity;

import com.techademy.productmaster.productmaster.model.Product;

public interface ProductMasterService {
	
	ResponseEntity<?> saveProduct(Product product);

}
