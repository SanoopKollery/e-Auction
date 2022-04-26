package com.techademy.productmaster.productmaster.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techademy.productmaster.productmaster.model.Transaction;

@FeignClient(value = "jplaceholder", url = "https://localhost:8083/e-auction/api/v1/buyer")
public interface TransactionClient {
	
	 @RequestMapping(method = RequestMethod.GET, value = "/getTransactions/{productId}")
	    List<Transaction> getBidDetails(@PathVariable("productId") String productId);

}
