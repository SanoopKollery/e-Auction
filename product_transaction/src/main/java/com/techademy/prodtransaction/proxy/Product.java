package com.techademy.prodtransaction.proxy;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class Product {

    private Long productId;
    private String productName;
    private String shortDescription;
    private String description;
    private String category;
    private double startingPrice;
    private Timestamp bidEndDate;

}
