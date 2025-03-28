package za.ac.cput.repository;
/*
   Implements ITransactionRepository to manage a collection of transactions.
   Provides functionality to add, read, update, delete, and retrieve transactions.
   Uses a singleton pattern to ensure a single instance is used throughout the application.
   Author: 222614153
*/
import za.ac.cput.domain.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository implements ITransactionRepository {

    private static ITransactionRepository repository = null;
    private List<Transaction> transactionList;

    private TransactionRepository() {
        transactionList = new ArrayList<>();
        System.out.println("Transaction Repository Created Successfully");
    }

    public static ITransactionRepository getRepository() {
        if (repository == null) {
            repository = new TransactionRepository();
        }
        return repository;
    }

    @Override
    public Transaction add(Transaction transaction) {
        boolean success = transactionList.add(transaction);
        if (success) {
            return transaction;
        }
        return null;
    }

    @Override
    public Transaction read(String transactionId) {
        for (Transaction t : transactionList) {
            if (t.getTransactionId().equalsIgnoreCase(transactionId))
                return t;
        }
        return null;
    }

    @Override
    public Transaction update(Transaction transaction) {
        String transactionId = transaction.getTransactionId();
        Transaction existingTransaction = read(transactionId);
        if (existingTransaction == null)
            return null;

        boolean success = delete(transactionId);
        if (success) {
            if (transactionList.add(transaction))
                return transaction;
        }
        return null;
    }

    @Override
    public boolean delete(String transactionId) {
        Transaction transactionToDelete = read(transactionId);
        if (transactionToDelete == null)
            return false;
        return transactionList.remove(transactionToDelete);
    }

    @Override
    public List<Transaction> getAll() {
        return transactionList;
    }
}