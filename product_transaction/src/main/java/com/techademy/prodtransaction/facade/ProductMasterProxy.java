package com.techademy.prodtransaction.facade;

import com.techademy.prodtransaction.proxy.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-master-service")
public interface ProductMasterProxy {
    @GetMapping("/e-auction/api/v1/seller/get-product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") long productId);

}
