package com.example.Library.controller;

import com.example.Library.dto.TxnRequest;
import com.example.Library.dto.TxnReturnRequest;
import com.example.Library.exception.BookException;
import com.example.Library.exception.UserException;
import com.example.Library.service.impl.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@Validated
@RequestMapping("/txn")
public class TxnController {

    @Autowired
    private TxnService txnService;

    @PostMapping("/issue")
    public String create(@RequestBody TxnRequest txnRequest) throws UserException, BookException {
        return txnService.create(txnRequest);
    }

    @PutMapping("/return")
    public Double returnTxn(@RequestBody TxnReturnRequest txnReturnRequest) throws BookException, UserException {
        return txnService.returnTxn(txnReturnRequest);
    }


}
// issue
// return

// test cases Junit 5
// redis caching
// security :
// minor 2

