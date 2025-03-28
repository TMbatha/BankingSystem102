package za.ac.cput.factory;
/*Account.java
Account model class
Author: Siyabulela Mgijima (230680305)
 */
import za.ac.cput.Domain.Account;
import za.ac.cput.Domain.Customer;
import za.ac.cput.util.Helper;
import java.time.LocalDate;
public class AccountFactory {
    public static Account createAccount(String accountNumber, double balance, LocalDate openDate, Customer customer) {
        if (Helper.stringIsNullOrEmpty(accountNumber)) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        if (openDate == null || openDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Open date cannot be in the future or null");
        }
        if (customer == null) {  // Check if customer is null
            throw new IllegalArgumentException("Customer cannot be null");
        }
        //comment

        return new Account.Builder()
                .setAccountNumber(accountNumber)
                .setBalance(balance)
                .setOpenDate(openDate)
                .setCustomer(customer)
                .build();
    }

}
