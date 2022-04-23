package com.techademy.prodtransaction.repository;

import com.techademy.prodtransaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    public Transaction findByProductIdAndEmail(int productID,String emailID);
    public List<Transaction> findAllByProductId(int productID);
}
