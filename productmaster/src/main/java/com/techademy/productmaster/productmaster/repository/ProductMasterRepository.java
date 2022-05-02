package com.techademy.productmaster.productmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techademy.productmaster.productmaster.model.Product;

@Repository
public interface ProductMasterRepository extends JpaRepository<Product,Long> {

}
