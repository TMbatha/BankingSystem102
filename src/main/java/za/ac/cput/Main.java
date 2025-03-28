package za.ac.cput;

import za.ac.cput.Domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create an address using the factory
        Address address = AddressFactory.createFullAddress("10", "Dorset", "Woodstock", "Cape Town", "Mzansi", 1234);
        System.out.println(address);

        // Create a contact using the factory
        Contact contact = ContactFactory.createContact("0761234567", "222222222@mycput.ac.za");
        System.out.println(contact);

        // Create a customer using the factory
        Customer customer = CustomerFactory.createCustomer("Thabiso", "Mbatha", address, contact);
        System.out.println(customer);

        // Create an account
        Account account = new Account.Builder()
                .setAccountNumber("ACC2468")
                .setBalance(5000.00)
                .setOpenDate(LocalDate.now())
                .setCustomer(customer)
                .build();

        System.out.println(account);

        // Create transactions using the factory
        Transaction deposit = TransactionFactory.createDeposit("TXN001", 1500.00, "2023-11-21");
        Transaction withdrawal = TransactionFactory.createWithdrawal("TXN002", 500.00, "2023-11-21");

        // Print transaction results
        System.out.println("=== Transaction Output ===");
        System.out.println(deposit);
        System.out.println(withdrawal);

        // Create a loan using the factory
        Loan loan = LoanFactory.createLoan(
                5.5,
                "approved",
                24,
                1500.0,
                customer
        );

        System.out.println("\n=== Loan Output ===");
        System.out.println(loan);

        // Create personal loan
        PersonalLoan personalLoan = PersonalLoanFactory.createPersonalLoan(
                150000.00,     // loan amount
                7.5,           // interest rate
                "approved",     // status
                60,            // 5-year tenure
                customer,      // existing customer object
                "Home Renovation",  // purpose
                "Property Deed"     // collateral
        );

        System.out.println("\n=== Personal Loan ===");
        System.out.println(personalLoan);
    }
}
