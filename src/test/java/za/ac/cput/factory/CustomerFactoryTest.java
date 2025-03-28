package za.ac.cput.factory;
/*
Author: Thabiso Mbatha (221563423)
 */

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class CustomerFactoryTest {
    private static Customer cus1 = CustomerFactory.createCustomer("Thabiso", "Mbatha", AddressFactory.createFullAddress("10", "Dorset", "Woodstocko", "Cape Town", "South Africa", 1992), ContactFactory.createContact("0722222222", "221222121@mycput.ac.za"));
    private static Customer cus2 = CustomerFactory.createCustomer("Lifa", "Mbangatha", AddressFactory.createFullAddress("10", "Dorset", "Woodstocko", "Cape Town", "South Africa", 1992), ContactFactory.createContact("0722222222", "Lifa@mycput.ac.za"));

    @Test
    @Order(1)
    public void testCreateCustomer(){
        assertNotNull(cus1);
        System.out.println(cus1.toString());
    }

    @Test
    @Order(2)
    public void testCreateCustomerThatFails(){
        fail();
        assertNotNull(cus2);
        System.out.println(cus2.toString());
    }

    @Test
    @Order(3)
    @Disabled
    public void testNotImplementedYet(){
        //not implemented
    }



}
