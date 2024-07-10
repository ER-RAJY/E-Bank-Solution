package com.example.E_Bank.Solution.service.impl;


import com.example.E_Bank.Solution.repository.TransactionRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    public List<Object> getTransactionsByUser(){
        return transactionRepository.findAllByUSER();
    }

    public List<Object> getAllTransactionByCompte(Long id_Compte) {
        return transactionRepository.findAllByCOMPTE(id_Compte);
    }


}
