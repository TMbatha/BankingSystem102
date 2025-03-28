package za.ac.cput;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.repository.ICustomerRepository;

public class Main {
    public static void main(String[] args) {
        Customer cus1 = CustomerFactory.createCustomer("Thabiso", "Mbatha", AddressFactory.createFullAddress("10", "Dorset", "Woodstocko", "Cape Town", "South Africa", 1992), ContactFactory.createContact("0722222222", "221222121@mycput.ac.za"));
        Customer cus2 = CustomerFactory.createCustomer("Lifa", "Mbangatha", AddressFactory.createFullAddress("10", "Dorset", "Woodstocko", "Cape Town", "South Africa", 1992), ContactFactory.createContact("0722222222", "Lifa@mycput.ac.za"));
        System.out.println(cus1);
        System.out.println(cus2);

        CustomerRepository cusRepo = (CustomerRepository) CustomerRepository.getRepository();

        cusRepo.addCustomer(cus1);
        cusRepo.addCustomer(cus2);

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

    }
}
