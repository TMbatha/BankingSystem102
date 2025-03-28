package za.ac.cput.factory;
/*
Author: Thabiso Mbatha (221563423)
 */

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

public class CustomerFactory {
    private String customerName, customerSurname;
    private Address customerAddress;
    private Contact customerContact;

    public static Customer createCustomer(String customerName, String customerSurname, Address address, Contact contact){
        if(Helper.stringIsNullOrEmpty(customerName) || Helper.stringIsNullOrEmpty(customerSurname)){
            return null;
        }
        return new Customer.Builder().setCustomerName(customerName).setCustomerSurname(customerSurname).setCustomerAddress(address).setCustomerContact(contact).build();
    }

}
