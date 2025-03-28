package za.ac.cput.factory;

/*
 * AccountFactoryTest.java
 * Test class for AccountFactory
 * Author: Siyabulela Mgijima (230680305)
 */

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Account;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.AccountFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountFactoryTest {

    private static Customer customer;
    private static Account account;


    @Test
    @Order(1)
    void a_createAccount() {
        account = AccountFactory.createAccount("ACC1001", 1500.00, LocalDate.now(), customer);
        assertNotNull(account);
        assertEquals("ACC1001", account.getAccountNumber());
        assertEquals(1500.00, account.getBalance());
        assertEquals(customer, account.getCustomer());
        System.out.println("Created Account: " + account);
    }

    @Test
    @Order(2)
    void b_createAccountWithInvalidBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AccountFactory.createAccount("ACC1002", -500.00, LocalDate.now(), customer));
        assertEquals("Balance cannot be negative", exception.getMessage());
    }

    @Test
    @Order(3)
    void c_createAccountWithFutureDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AccountFactory.createAccount("ACC1003", 1000.00, LocalDate.now().plusDays(5), customer));
        assertEquals("Open date cannot be in the future or null", exception.getMessage());
    }

    @Test
    @Order(4)
    void d_createAccountWithNullCustomer() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AccountFactory.createAccount("ACC1004", 2000.00, LocalDate.now(), null));
        assertEquals("Customer cannot be null", exception.getMessage());
    }
}