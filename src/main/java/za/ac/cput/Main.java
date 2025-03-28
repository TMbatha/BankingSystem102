package za.ac.cput;

import za.ac.cput.domain.Account;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.AccountFactory;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.repository.AccountRepository;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.repository.IAccountRepository;
import za.ac.cput.repository.ICustomerRepository;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer cus1 = CustomerFactory.createCustomer("Thabiso", "Mbatha", AddressFactory.createFullAddress("10", "Dorset", "Woodstocko", "Cape Town", "South Africa", 1992), ContactFactory.createContact("0722222222", "221222121@mycput.ac.za"));
        Customer cus2 = CustomerFactory.createCustomer("Lifa", "Mbangatha", AddressFactory.createFullAddress("10", "Dorset", "Woodstocko", "Cape Town", "South Africa", 1992), ContactFactory.createContact("0722222222", "Lifa@mycput.ac.za"));
        System.out.println(cus1);
        System.out.println(cus2);

        CustomerRepository cusRepo = (CustomerRepository) CustomerRepository.getRepository();

        cusRepo.add(cus1);
        cusRepo.add(cus2);

        System.out.println("We are here");
        System.out.println(cusRepo.read("Lifa"));

        System.out.println("Before Update: " + cusRepo.getAll());

        Customer updatedCustomer = CustomerFactory.createCustomer("Lifa", "Zulu", AddressFactory.createFullAddress("10", "Dorset", "Woodstocko", "Cape Town", "South Africa", 1992), ContactFactory.createContact("0722222222", "Lifa@mycput.ac.za"));


        // Call the update method
        Customer updated = cusRepo.update(updatedCustomer);

        // Check if the update was successful
        if (updated != null) {
            System.out.println("Update Successful: " + updated);
        } else {
            System.out.println("Update Failed");
        }

        // Display all customers after the update
        System.out.println("After Update: " + cusRepo.getAll());


        //***********************************************************************
        //Deleting an object
        cusRepo.delete("Thabiso");
        System.out.println("After Delete: " + cusRepo.getAll());

        // Create accounts using the factory
        Account acc1 = AccountFactory.createAccount(
                "ACC123", 1000.0, LocalDate.now(), cus1
        );
        Account acc2 = AccountFactory.createAccount(
                "ACC456", 500.0, LocalDate.now(), cus2
        );

        // Get the repository instance
        IAccountRepository accountRepo = AccountRepository.getRepository();

        // Add accounts to the repository
        accountRepo.add(acc1);
        accountRepo.add(acc2);

        // Read an account
        System.out.println("Read Account: " + accountRepo.read("ACC123"));

        // Update an account
        Account updatedAccount = AccountFactory.createAccount(
                "ACC123", 2000.0, LocalDate.now(), cus1
        );
        accountRepo.update(updatedAccount);
        System.out.println("Updated Account: " + accountRepo.read("ACC123"));

        // Delete an account
        accountRepo.delete("ACC456");
        System.out.println("After Delete: " + accountRepo.getAll());

    }
}
