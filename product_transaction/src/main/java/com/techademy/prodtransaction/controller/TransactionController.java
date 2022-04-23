package com.techademy.prodtransaction.controller;


import com.techademy.prodtransaction.exception.TransactionNotFoundException;
import com.techademy.prodtransaction.model.Transaction;
import com.techademy.prodtransaction.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/e-auction/api/v1/buyer")
public class TransactionController {

    Logger logger =LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService trxService;
    @PostMapping("/place-bid")
    public ResponseEntity<?> saveTransaction(@RequestBody @Valid  Transaction transaction)
    {
        return  trxService.saveTransaction(transaction);
    }

    @PutMapping("/update-bid/{productId}/{buyerEmailld}/{newBidAmount}")
    public ResponseEntity<?> updateBidTransaction(@PathVariable("productId") int producctID,
                                               @PathVariable("buyerEmailld") String email,
                                               @PathVariable("newBidAmount")BigDecimal bidAmount) throws TransactionNotFoundException {
        return trxService.updateBidTransaction(producctID,email,bidAmount);
    }

    @GetMapping("/getTransactions/{productId}")
    public List<Transaction> getTransactions(@PathVariable("productId") int productID)
    {
       return trxService.getTransactions(productID);
    }
}
