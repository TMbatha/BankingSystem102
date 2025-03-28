package za.ac.cput.repository;
/*
   Interface for managing transactions in the banking system.
   Provides methods for adding, reading, updating, deleting, and retrieving all transactions.
   Author: 222614153
*/
import za.ac.cput.domain.Transaction;

import java.util.List;

public interface ITransactionRepository extends IRepository<Transaction, String> {
    List<Transaction> getAll();
}