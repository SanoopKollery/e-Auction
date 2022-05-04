package com.techademy.productmaster.productmaster.controller;

import javax.validation.Valid;

import com.techademy.productmaster.productmaster.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.techademy.productmaster.productmaster.exception.GenericException;
import com.techademy.productmaster.productmaster.model.Product;
import com.techademy.productmaster.productmaster.service.ProductMasterService;

@RestController
@RequestMapping("/e-auction/api/v1/seller")
public class ProductMasterController {

	private static final Logger logger = LoggerFactory.getLogger(ProductMasterController.class);


	
	
	private ProductMasterService masterService;
	
	public ProductMasterController(ProductMasterService masterService) {
		this.masterService = masterService;	
	}
	
	@PostMapping("/add-product")
	public ResponseEntity<?> addProduct(@RequestBody @Valid Product product) throws GenericException {
		logger.info("somnath-info");
		logger.debug("somnath--debug");
		logger.error("somnath---error");
		
		return masterService.saveProduct(product);
	}
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity deleteProduct(@PathVariable long productId) throws GenericException{
		return masterService.deleteProduct(productId);
	}

	@GetMapping("/get-product/{productId}")
	public ResponseEntity getProduct(@PathVariable long productId) throws GenericException, ProductNotFoundException {
		return masterService.getProduct(productId);
	}
	

}
