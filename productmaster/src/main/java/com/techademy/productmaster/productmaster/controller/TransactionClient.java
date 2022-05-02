package com.techademy.productmaster.productmaster.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techademy.productmaster.productmaster.model.Transaction;

@FeignClient(name="product-txn-service")
public interface TransactionClient {
	
	    @GetMapping( value = "/e-auction/api/v1/buyer/getTransactions/{productId}")
	    List<Transaction> getBidDetails(@PathVariable("productId") long productId);

}
