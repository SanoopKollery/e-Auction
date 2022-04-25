package com.techademy.productmaster.productmaster.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="TBL_ProductMaster")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product{

	@NotNull
	@Min(value = 5)
	@Max(value = 30)
	private String productName;
	private String shortDescription;
	private String description;
	private String cataegory;
	private double startingPrice;
	@Future(message = "Bid end date should be future")
	private Date bidEndDate;
	private ProductCategory category;
	
}
