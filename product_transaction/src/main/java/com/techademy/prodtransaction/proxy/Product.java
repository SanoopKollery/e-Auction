package com.techademy.prodtransaction.proxy;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class Product {

    private String productName;
    private String shortDescription;
    private String detailedDescription;
    private String category;
    private BigDecimal startingPrice;
    private Timestamp bidEndDate;

}
