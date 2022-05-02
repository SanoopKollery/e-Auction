package com.techademy.productmaster.productmaster.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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


	@JsonIgnore
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long productId;
	@NotNull
	@Size(min = 5,max=30)
	private String productName;
	private String shortDescription;
	private String description;
	private String category;
	private BigDecimal startingPrice;
	private Timestamp bidEndDate;
}
