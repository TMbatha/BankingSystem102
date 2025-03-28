package za.ac.cput;

import za.ac.cput.Domain.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Address add = new Address.Builder().setHouseNumber("10").build();
        System.out.println(add);
        Contact contact = new Contact.Builder().setEmail("ttt").build();
        System.out.println(contact);

        Customer cus1 = new Customer.Builder().setCustomerName("Thabiso").setCustomerSurname("Mbatha").setCustomerAddress(new Address.Builder().setHouseNumber("10").setStreetName("Dorset").setSurburb("Woodstock").setCity("Cape Town").setPostalCode(1234).setCountry("Mzansi").build()).setCustomerContact(new Contact.Builder().setPhoneNumber("0761234567").setEmail("222222222@mycput.ac.za").build()).build();

        System.out.println(cus1);
        System.out.println(cus1);

        Account account = new Account.Builder()
                .setAccountNumber("ACC2468")
                .setBalance(5000.00)
                .setOpenDate(LocalDate.now())
                .setCustomer(cus1)
                .build();

        System.out.println(account);

        PersonalLoan pl =(PersonalLoan) new PersonalLoan.PersonalLoanBuilder().setPurpose("Travel").setCollateral("Car").setCustomer(cus1).setTenureMonths(24).setStatus("Approved").setInterestRate(5.5).setLoanAmount(100000).setMonthlyEMI(5000).build();

        System.out.println("Original PersonalLoan:");
        System.out.println(pl);
        // Creating a copy of the PersonalLoan object
        PersonalLoan copiedLoan = new PersonalLoan.PersonalLoanBuilder()
                .copy(pl)
                .build();
        // Display the copied PersonalLoan
        System.out.println("\nCopied PersonalLoan:");
        System.out.println(copiedLoan);
    }
}


