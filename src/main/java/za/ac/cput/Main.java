package za.ac.cput;

import za.ac.cput.Domain.Account;
import za.ac.cput.Domain.Address;
import za.ac.cput.Domain.Contact;
import za.ac.cput.Domain.Customer;
import za.ac.cput.Domain.Transaction;
import za.ac.cput.factory.TransactionFactory;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;

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
    }
}
