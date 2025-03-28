package za.ac.cput.repository;
/*
Author: 222614153
Description: Unit tests for the TransactionRepository class to ensure proper management of Transaction objects.
 */

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Transaction;
import za.ac.cput.factory.TransactionFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class TransactionRepositoryTest {
    private static ITransactionRepository transactionRepo = TransactionRepository.getRepository();
    private static Transaction deposit = new Transaction.Builder()
            .transactionId("TXN001")
            .amount(1500.00)
            .date("2023-11-21")
            .type("DEPOSIT")
            .build();

    private static Transaction withdrawal = new Transaction.Builder()
            .transactionId("TXN002")
            .amount(500.00)
            .date("2023-11-21")
            .type("WITHDRAWAL")
            .build();

    @Test
    @Order(1)
    void a_add() {
        Transaction transactionAdded = transactionRepo.add(deposit);
        assertNotNull(transactionAdded);
        System.out.println("Added Transaction: " + transactionAdded);
    }

    @Test
    @Order(2)
    void b_read() {
        Transaction read = transactionRepo.read(deposit.getTransactionId());
        assertNotNull(read);
        System.out.println("Read Transaction: " + read);
    }

    @Test
    @Order(3)
    void c_update() {
        Transaction updatedDeposit = new Transaction.Builder()
                .transactionId("TXN001")
                .amount(2000.00)
                .date("2023-11-22")
                .type("DEPOSIT")
                .build();

        Transaction updated = transactionRepo.update(updatedDeposit);
        assertNotNull(updated);
        System.out.println("Updated Transaction: " + updated);
    }

    @Test
    @Order(4)
    void d_delete() {
        assertTrue(transactionRepo.delete(deposit.getTransactionId()));
        System.out.println("Success: Transaction Deleted!");
    }

    @Test
    @Order(5)
    void e_getAll() {
        System.out.println("All Transactions: " + transactionRepo.getAll());
    }
}