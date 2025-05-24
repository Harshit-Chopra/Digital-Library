package com.example.Library.repository;

import com.example.Library.model.Txn;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface TxnRepository extends JpaRepository<Txn, Integer> {

        Txn findByTxnId(String txnId);
    }
