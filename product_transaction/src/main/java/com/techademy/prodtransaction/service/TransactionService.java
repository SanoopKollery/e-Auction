package com.techademy.prodtransaction.service;


import com.techademy.prodtransaction.exception.BidDateExpiredException;
import com.techademy.prodtransaction.exception.ProductNotFound;
import com.techademy.prodtransaction.exception.TransactionNotFoundException;
import com.techademy.prodtransaction.facade.ProductMasterProxy;
import com.techademy.prodtransaction.model.Transaction;
import com.techademy.prodtransaction.proxy.Product;
import com.techademy.prodtransaction.repository.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    private ProductMasterProxy proxy;

    public TransactionService(TransactionRepository transactionRepository, ProductMasterProxy proxy) {
        this.transactionRepository=transactionRepository;
        this.proxy=proxy;
    }

    public ResponseEntity<?> saveTransaction(Transaction trxn) throws BidDateExpiredException, ProductNotFound {

        Product product= null;
        try {
             product=proxy.getProduct(trxn.getProductId( )).getBody( );
        }
        catch (Exception e) {
            throw new ProductNotFound("Product not found !!");
        }
        if (product.getBidEndDate().before(new Timestamp(System.currentTimeMillis())))
        {
            throw new BidDateExpiredException("Bid date expired !!");
        }

        Transaction transaction = Transaction.builder()
                .firstName(trxn.getFirstName())
                .lastName(trxn.getLastName())
                .address(trxn.getAddress())
                .city(trxn.getCity())
                .state(trxn.getState())
                .pin(trxn.getPin())
                .phone(trxn.getPhone())
                .email(trxn.getEmail())
                .productId(trxn.getProductId())
                .bidAmount(trxn.getBidAmount())
                .build();
        transactionRepository.save(transaction);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    public ResponseEntity<?> updateBidTransaction(int productID, String email, BigDecimal bidAmount) throws TransactionNotFoundException {

        if (bidAmount.compareTo(BigDecimal.ZERO) <= 0)
            return new ResponseEntity<>("Bid amount should be greater than 1", HttpStatus.OK);
        Transaction transaction = transactionRepository.findByProductIdAndEmail(productID,email);
        if (transaction == null || transaction.getTrx_ID() == 0)
           throw new TransactionNotFoundException(" No bid found !!");
        transaction.setBidAmount(bidAmount);
        transactionRepository.save(transaction);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    public List<Transaction> getTransactions(int producctID) {
        return  transactionRepository.findAllByProductId(producctID);
    }


}
