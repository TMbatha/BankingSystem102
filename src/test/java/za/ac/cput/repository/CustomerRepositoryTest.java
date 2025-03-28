package za.ac.cput.repository;
/*
Author: Thabiso Mbatha (221563423)
 */

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerRepositoryTest {
    private static CustomerRepository cusRepo = (CustomerRepository) CustomerRepository.getRepository();
    private static Customer cus1 = CustomerFactory.createCustomer("Thabiso", "Mbatha", AddressFactory.createFullAddress("10", "Dorset", "Woodstocko", "Cape Town", "South Africa", 1992), ContactFactory.createContact("0722222222", "221222121@mycput.ac.za"));

    @Test
    @Order(1)
    void a_add(){
        Customer customerAdded = cusRepo.add(cus1);
        assertNotNull(customerAdded);
        System.out.println(customerAdded);
    }

    @Test
    @Order(2)
    void b_read(){
        Customer read = cusRepo.read(cus1.getCustomerName());
        assertNotNull(read);
        System.out.println(read.toString());
    }

    @Test
    @Order(3)
    void c_update(){
        Customer newCus = CustomerFactory.createCustomer("Zingah", "Mbatha", AddressFactory.createFullAddress("10", "Dorset", "Woodstocko", "Cape Town", "South Africa", 1992), ContactFactory.createContact("0722222222", "221222121@mycput.ac.za"));
        Customer updated = cusRepo.update(newCus);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    @Disabled
    void d_delete(){
        assertTrue(cusRepo.delete(cus1.getCustomerName()));
        System.out.println("Success: Customer Deleted!");

    }

    @Test
    void e_getAll(){
        System.out.println(cusRepo.getAll());
    }

}
