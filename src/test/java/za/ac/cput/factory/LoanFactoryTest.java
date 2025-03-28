package za.ac.cput.factory;

import org.junit.jupiter.api.*;
        import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Loan;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LoanFactoryTest {
    private static Customer customer1 = CustomerFactory.createCustomer(
            "Thabiso",
            "Mbatha",
            AddressFactory.createFullAddress("10", "Dorset", "Woodstock", "Cape Town", "South Africa", 1992),
            ContactFactory.createContact("0722222222", "thabiso@mycput.ac.za")
    );

    private static Customer customer2 = CustomerFactory.createCustomer(
            "Lifa",
            "Mbangatha",
            AddressFactory.createFullAddress("10", "Dorset", "Woodstock", "Cape Town", "South Africa", 1992),
            ContactFactory.createContact("0722222222", "lifa@mycput.ac.za")
    );

    private static Loan loan1 = LoanFactory.createLoan(
            150000.00,
            5.5,
            "approved",
            24,
            2000.00,
            customer1,
            "Education",
            "Property Deed"
    );

    private static Loan loan2 = LoanFactory.createLoan(
            -50000.00, // Invalid negative loan amount
            7.0,
            "pending",
            12,
            1500.00,
            customer2,
            "", // Invalid empty purpose
            ""  // Invalid empty collateral
    );

    @Test
    @Order(1)
    void testCreateLoan() {
        assertNotNull(loan1);
        System.out.println("Loan 1: " + loan1);
    }

    @Test
    @Order(2)
    void testCreateLoanThatFails() {
        fail(); // Force test failure for demonstration
        assertNull(loan2); // This would check if invalid loan is null
        System.out.println("Loan 2: " + loan2);
    }

    @Test
    @Order(3)
    @Disabled
    void testNotImplementedYet(){}
}
