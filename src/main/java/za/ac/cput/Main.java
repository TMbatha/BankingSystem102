package za.ac.cput;

import za.ac.cput.Domain.Account;
import za.ac.cput.Domain.Customer;
import za.ac.cput.factory.AccountFactory;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Creating a Customer instance
        Customer cus3 = CustomerFactory.createCustomer(
                "Thabiso", "Mbatha",
                AddressFactory.createShortAddress("10", "Dorset", "Woodstock"),
                ContactFactory.createContact("0761234567", "222222222@mycput.ac.za")
        );

        // Correct way to create LocalDate
        LocalDate openDate = LocalDate.of(2022, 8, 10);

        // Creating an Account instance
        Account account1 = AccountFactory.createAccount("12345678", 5000.00, openDate, cus3);

        // Printing results
        System.out.println(cus3);
        System.out.println(account1);
    }
}

