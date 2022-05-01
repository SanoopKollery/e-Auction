package com.techademy.prodtransaction.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product-price-master")
public class ProductMasterProxy {

    //@GetMapping("/product/v1/getproductcode/{code}")
   // public ResponseEntity<ProductCalculator> getProduct(@PathVariable("code") String code);
}
