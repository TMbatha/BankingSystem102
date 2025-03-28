package za.ac.cput.factory;
/*
Author: 222614153
Description: Unit tests for the TransactionFactory class to ensure proper creation of Transaction objects.
 */

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Transaction;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransactionFactoryTest {
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
    public void testCreateDepositTransaction() {
        assertNotNull(deposit);
        System.out.println("Created Deposit Transaction: " + deposit);
    }

    @Test
    @Order(2)
    public void testCreateWithdrawalTransaction() {
        assertNotNull(withdrawal);
        System.out.println("Created Withdrawal Transaction: " + withdrawal);
    }

    @Test
    @Order(3)
    @Disabled("Not implemented yet")
    public void testNotImplementedYet() {
        // Placeholder for future tests
    }
}