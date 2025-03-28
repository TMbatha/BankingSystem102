package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Loan;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.LoanFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LoanRepositoryTest {
    private static ILoanRepository loanRepo = LoanRepository.getRepository();
    private static Customer customer = CustomerFactory.createCustomer(
            "Thabiso",
            "Mbatha",
            AddressFactory.createFullAddress("10", "Dorset", "Woodstock", "Cape Town", "South Africa", 1992),
            ContactFactory.createContact("0722222222", "thabiso@mycput.ac.za")
    );
    private static Loan loan = LoanFactory.createLoan(
            150000.00,
            5.5,
            "approved",
            24,
            2000.00,
            customer,
            "Education",
            "Property Deed"
    );

    @Test
    @Order(1)
    void a_add() {
        Loan addedLoan = loanRepo.add(loan);
        assertNotNull(addedLoan);
        System.out.println("Added Loan: " + addedLoan);
    }

    @Test
    @Order(2)
    void b_read() {
        Loan readLoan = loanRepo.read(loan.getCustomer().getCustomerName());
        assertNotNull(readLoan);
        System.out.println("Read Loan: " + readLoan);
    }

    @Test
    @Order(3)
    void c_update() {
        Loan updatedLoan = LoanFactory.createLoan(
                160000.00,
                5.5,
                "approved",
                24,
                2000.00,
                customer,
                "Education",
                "Updated Collateral"
        );
        Loan result = loanRepo.update(updatedLoan);
        assertNotNull(result);
        System.out.println("Updated Loan: " + result);
    }

    @Test
    @Order(4)
    @Disabled
    void d_delete() {
        boolean success = loanRepo.delete(loan.getCustomer().getCustomerName());
        assertTrue(success);
        System.out.println("Success: Loan Deleted!");
    }

    @Test
    @Order(5)
    void e_getAll() {
        System.out.println("All Loans: " + loanRepo.getAll());
    }
}