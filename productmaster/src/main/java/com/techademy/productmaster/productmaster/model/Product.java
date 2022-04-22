package com.techademy.productmaster.productmaster.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable{

	private String productName;
	private String shortDescription;
	private String description;
	private String cataegory;
	private double startingPrice;
	private Date bidEndDate;
	
}
