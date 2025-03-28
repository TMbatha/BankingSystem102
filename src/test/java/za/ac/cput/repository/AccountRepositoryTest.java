package za.ac.cput.repository;

/*
 * AccountRepositoryTest.java
 * Test class for AccountRepository
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
class AccountRepositoryTest {

    private static AccountRepository accountRepo;
    private static Account account1;
    private static Account account2;
    private static Customer customer1;
    private static Customer customer2;

    @BeforeAll
    static void setUp() {
        accountRepo = (AccountRepository) AccountRepository.getRepository();

        customer1 = CustomerFactory.createCustomer("Alice", "Brown",
                AddressFactory.createFullAddress("20", "Green Ave", "Suburb", "Cape Town", "South Africa", 8001),
                ContactFactory.createContact("0823456789", "alice.brown@example.com"));

        customer2 = CustomerFactory.createCustomer("Bob", "Smith",
                AddressFactory.createFullAddress("45", "Blue Street", "Downtown", "Johannesburg", "South Africa", 2001),
                ContactFactory.createContact("0834567890", "bob.smith@example.com"));

        account1 = AccountFactory.createAccount("ACC2001", 3000.00, LocalDate.now(), customer1);
        account2 = AccountFactory.createAccount("ACC2002", 5000.00, LocalDate.now(), customer2);
    }

    @Test
    @Order(1)
    void a_add() {
        Account added1 = accountRepo.add(account1);
        Account added2 = accountRepo.add(account2);
        assertNotNull(added1);
        assertNotNull(added2);
        System.out.println("Added Accounts: " + added1 + "\n" + added2);
    }

    @Test
    @Order(2)
    void b_read() {
        Account readAccount = accountRepo.read(account1.getAccountNumber());
        assertNotNull(readAccount);
        assertEquals(account1.getAccountNumber(), readAccount.getAccountNumber());
        System.out.println("Read Account: " + readAccount);
    }

    @Test
    @Order(3)
    void c_update() {
        Account updatedAccount = AccountFactory.createAccount("ACC2001", 7000.00, LocalDate.now(), customer1);
        Account result = accountRepo.update(updatedAccount);
        assertNotNull(result);
        assertEquals(7000.00, result.getBalance());
        System.out.println("Updated Account: " + result);
    }

    @Test
    @Order(4)
    @Disabled
    void d_delete() {
        assertTrue(accountRepo.delete("ACC2002"));
        System.out.println("Deleted Account ACC2002.");
    }

    @Test
    @Order(5)
    void e_getAll() {
        System.out.println("All Accounts: " + accountRepo.getAll());
    }
}