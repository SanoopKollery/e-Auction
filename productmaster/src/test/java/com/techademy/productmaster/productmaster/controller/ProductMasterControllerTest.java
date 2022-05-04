package com.techademy.productmaster.productmaster.controller;

import com.google.gson.Gson;
import com.techademy.productmaster.productmaster.exception.ProductNotFoundException;
import com.techademy.productmaster.productmaster.model.Product;
import com.techademy.productmaster.productmaster.service.ProductMasterService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductMasterController.class)
class ProductMasterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductMasterService  productMasterService;

    @Test
    void addProduct()throws  Exception {

        String jsonRequest="\"productName\":\"PRD001\",\n" +
                "\t\"shortDescription\":\"PRD 001\",\n" +
                "\t\"description\":\"PRODUCT 001\",\n" +
                "\t\"category\":\"PAINTING\",\n" +
                "\t\"startingPrice\":\"20.0\",\n" +
                "\t\"bidEndDate\":\"2022-06-01\"";

        Product product = new Product();
        Timestamp ts = new Timestamp(new Date().getTime());
      //  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        product.setStartingPrice(new BigDecimal(20.0));
        product.setBidEndDate(ts);
        product.setCategory("PAINTING");
        product.setDescription("PRODUCT 001");
        product.setProductId(1L);
        product.setProductName("PRD001");
        product.setShortDescription("PRD 001");
  System.out.println("somnath-----"+new Gson().toJson(product));
        Mockito.when(productMasterService.saveProduct(product)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(post("/e-auction/api/v1/seller/add-product").content(jsonRequest).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void deleteProduct() throws Exception {
        Mockito.when(productMasterService.deleteProduct(1)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(delete("/e-auction/api/v1/seller/delete/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void getProduct() throws ProductNotFoundException,Exception {

        Mockito.when(productMasterService.getProduct(1)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(get("/e-auction/api/v1/seller/get-product/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}