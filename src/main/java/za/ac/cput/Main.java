package za.ac.cput;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Loan;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.LoanFactory;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.repository.ICustomerRepository;
import za.ac.cput.repository.ILoanRepository;
import za.ac.cput.repository.LoanRepository;

import java.util.List;

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

        // Get existing customer repository instance
       // ICustomerRepository customerRepo = CustomerRepository.getRepository();

        // Retrieve existing customers
       // Customer thabiso = cusRepo.read("Thabiso");
        Customer lifa = cusRepo.read("Lifa");

        // Verify customers exist
        if (lifa == null) {
            System.out.println("Error: Customers not found in repository!");
            return;
        } else {
            System.out.println("Lifa: " + lifa);
        }

        // Get loan repository
        ILoanRepository loanRepo = LoanRepository.getRepository();

        // Retrieve all loans for Lifa
        System.out.println(loanRepo.getAll());

        //create loann objects
        Loan loan = LoanFactory.createLoan(300000, 5.5, "Approved", 24, 6000, cus1, "Travel", "House");
        Loan loan2 = LoanFactory.createLoan(110000, 7.5, "Approved", 36, 2000, cus2, "savings", "Car" );


        //add them to repo
        loanRepo.add(loan);
        loanRepo.add(loan2);



        System.out.println("Before Update: " + loanRepo.getAll());


        Loan updatedLoan = LoanFactory.createLoan(20000, 3.3, "Approved", 12,2500, cus1, "Travel", "car");

        //update
        loanRepo.update(updatedLoan);

        System.out.println("After Updating: " + loanRepo.getAll());

        //delete
        loanRepo.delete("Travel");
        System.out.println("After Deleting: " + loanRepo.getAll());

    }
}
