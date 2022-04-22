package com.techademy.productmaster.productmaster.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller implements Serializable{

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int phone;
	private String email;
}
