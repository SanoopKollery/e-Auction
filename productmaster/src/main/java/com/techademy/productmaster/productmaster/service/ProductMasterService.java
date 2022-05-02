package com.techademy.productmaster.productmaster.service;

import com.techademy.productmaster.productmaster.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;

import com.techademy.productmaster.productmaster.exception.GenericException;
import com.techademy.productmaster.productmaster.model.Product;

public interface ProductMasterService {

	ResponseEntity<?> saveProduct(Product product) throws GenericException;

	ResponseEntity<?> deleteProduct(long productId) throws GenericException;

	ResponseEntity<?> getProduct(long productId) throws ProductNotFoundException;
}
