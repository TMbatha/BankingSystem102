package za.ac.cput;

import za.ac.cput.Domain.Account;
import za.ac.cput.Domain.Address;
import za.ac.cput.Domain.Contact;
import za.ac.cput.Domain.Customer;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Address add = new Address.Builder().setHouseNumber("10").build();
        System.out.println(add);
        Contact contact = new Contact.Builder().setEmail("ttt").build();
        System.out.println(contact);

        Customer cus1 = new Customer.Builder().setCustomerName("Thabiso").setCustomerSurname("Mbatha").setCustomerAddress(new Address.Builder().setHouseNumber("10").setStreetName("Dorset").setSuburb("Woodstock").setCity("Cape Town").setPostalCode(1234).setCountry("Mzansi").build()).setCustomerContact(new Contact.Builder().setPhoneNumber("0761234567").setEmail("222222222@mycput.ac.za").build()).build();

        System.out.println(cus1);
        System.out.println(cus1);

        Account account = new Account.Builder()
                .setAccountNumber("ACC2468")
                .setBalance(5000.00)
                .setOpenDate(LocalDate.now())
                .setcustomerName("Thabiso")
                .build();

        System.out.println(account);


        Address shortAddy1 = AddressFactory.createShortAddress("10", "Dorset Street", "Woodstock");
        Address shortAddy2 = AddressFactory.createShortAddress("", "Dorset Street", "Woodstock");

        System.out.println(shortAddy1);
        System.out.println(shortAddy2);

        Address fullAddy1 = AddressFactory.createFullAddress("11", "Dorset Street", "Woodstock", "Cape Town", "South Africa", 0);
        Address fullAddy2 = AddressFactory.createFullAddress("94", "Dorset Street", "Woodstock", "Cape Town", "South Africa", 1977);

        System.out.println(fullAddy1);
        System.out.println(fullAddy2);

        Contact contact1 = ContactFactory.createContact("0676282186", "222222222@mycput.ac.za");

        Customer cus3 = CustomerFactory.createCustomer("Thabiso", "Mbatha", AddressFactory.createShortAddress("1223", "Hanover Street", "District 6"), ContactFactory.createContact("011-000-0000", "Joshua@door.com"));

        System.out.println(contact1);
        System.out.println(cus3);
    }
}
