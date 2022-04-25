package com.techademy.productmaster.productmaster.controller;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techademy.productmaster.productmaster.model.Product;
import com.techademy.productmaster.productmaster.service.ProductMasterService;

@RestController
@RequestMapping("/e-auction/api/v1/seller")
public class ProductMasterController {
	
	
	private ProductMasterService masterService;
	
	public ProductMasterController(ProductMasterService masterService) {
		this.masterService = masterService;	
	}
	
	@PostMapping("/add-product")
	public ResponseEntity addProduct(@RequestBody @Valid Product product){
		
		return masterService.saveProduct(product);
	}
	

}
