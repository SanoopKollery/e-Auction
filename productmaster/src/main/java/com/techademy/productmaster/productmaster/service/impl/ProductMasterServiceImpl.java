package com.techademy.productmaster.productmaster.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techademy.productmaster.productmaster.model.Product;
import com.techademy.productmaster.productmaster.repository.ProductMasterRepository;
import com.techademy.productmaster.productmaster.service.ProductMasterService;

@Service
public class ProductMasterServiceImpl implements ProductMasterService{

	@Autowired
	private ProductMasterRepository masterRepository;

	@Override
	public ResponseEntity<?> saveProduct(Product product) {
		
		Product prod = Product.builder()
				.productName(product.getProductName())
				.shortDescription(product.getShortDescription())
				.bidEndDate(product.getBidEndDate())
				.cataegory(product.getCataegory())
				.startingPrice(product.getStartingPrice())
				.description(product.getDescription())
				.build();
				
		return new ResponseEntity<>(prod,HttpStatus.OK);
	}

	
	
	

}
