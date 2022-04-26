package com.techademy.productmaster.productmaster.service.impl;


import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techademy.productmaster.productmaster.controller.TransactionClient;
import com.techademy.productmaster.productmaster.exception.GenericException;
import com.techademy.productmaster.productmaster.model.Product;
import com.techademy.productmaster.productmaster.model.ProductCategory;
import com.techademy.productmaster.productmaster.model.Transaction;
import com.techademy.productmaster.productmaster.repository.ProductMasterRepository;
import com.techademy.productmaster.productmaster.service.ProductMasterService;

@Service
public class ProductMasterServiceImpl implements ProductMasterService{

	@Autowired
	private ProductMasterRepository masterRepository;
	@Autowired
	private TransactionClient txnClient;

	@Override
	public ResponseEntity<?> saveProduct(Product product) {
		
		ProductCategory cat = ProductCategory.valueOf(product.getCataegory());
		int futureOrNot = compareDate(product.getBidEndDate());
		if(futureOrNot == 1) {
		Product prod = Product.builder()
				.productName(product.getProductName())
				.shortDescription(product.getShortDescription())
				.bidEndDate(product.getBidEndDate())
				.cataegory(cat.getDisplayName())
				.startingPrice(product.getStartingPrice())
				.description(product.getDescription())
				.build();
		masterRepository.save(prod);
		}
		else {
			//throw customexception;
		}
				
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<?> deleteProduct(String productId) throws GenericException {

		Optional<Product> productDetails = masterRepository.findById(productId);

		List<Transaction> bidTxn = txnClient.getBidDetails(productId);

		int txnCount = bidTxn.size();
		if (Objects.nonNull(productDetails)) {
			try {
				if (compareDate(productDetails.get().getBidEndDate()) != -1 & txnCount == 0) {
					masterRepository.deleteById(productId);
				}
			} catch (Exception ex) {
				throw new GenericException("Product cannot be deleted");
			}

		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	private static int compareDate(String date) {
		Date bidEndDate = null;
		try {
			bidEndDate = DateUtils.parseDate(date, 
					  new String[] { "yyyy-MM-dd", "yyyy-mm-dd hh:mm:ss" });
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date currentDate = DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH);
		return bidEndDate.compareTo(currentDate);
	}
	
	
	

}
