package za.ac.cput;

import za.ac.cput.Domain.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // 1. Create Address
        Address add = new Address.Builder().setHouseNumber("10").build();
        System.out.println(add);

        // 2. Create Contact
        Contact contact = new Contact.Builder().setEmail("ttt").build();
        System.out.println(contact);

        // 3. Create Customer
        Customer cus1 = new Customer.Builder()
                .setCustomerName("Thabiso")
                .setCustomerSurname("Mbatha")
                .setCustomerAddress(new Address.Builder()
                        .setHouseNumber("10")
                        .setStreetName("Dorset")
                        .setSurburb("Woodstock")
                        .setCity("Cape Town")
                        .setPostalCode(1234)
                        .setCountry("Mzansi")
                        .build())
                .setCustomerContact(new Contact.Builder()
                        .setPhoneNumber("0761234567")
                        .setEmail("222222222@mycput.ac.za")
                        .build())
                .build();

        System.out.println(cus1);

        // 4. Create Account
        Account account = new Account.Builder()
                .setAccountNumber("ACC2468")
                .setBalance(5000.00)
                .setOpenDate(LocalDate.now())
                .setCustomer(cus1)
                .build();

        System.out.println(account);

        // 5. Create deposit transaction
        Transaction deposit = new Transaction.Builder()
                .transactionId("TXN001")
                .amount(1500.00)
                .date("2023-11-21")
                .type("DEPOSIT")
                .build();

        // 6. Create withdrawal transaction
        Transaction withdrawal = new Transaction.Builder()
                .transactionId("TXN002")
                .amount(500.00)
                .date("2023-11-21")
                .type("WITHDRAWAL")
                .build();

        // 7. Print transaction results
        System.out.println("=== Transaction Output ===");
        System.out.println(deposit);
        System.out.println(withdrawal);


        PersonalLoan pl = (PersonalLoan) new PersonalLoan.PersonalLoanBuilder().setPurpose("Travel").setCollateral("Car").setCustomer(cus1).setTenureMonths(24).setStatus("Approved").setInterestRate(7.5).setLoanAmount(100000).setMonthlyEMI(5000).build
                ();
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
