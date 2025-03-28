package za.ac.cput.factory;

import za.ac.cput.Domain.PersonalLoan;
import za.ac.cput.Domain.Customer;
import za.ac.cput.util.Helper;

public class PersonalLoanFactory {

    public static PersonalLoan createPersonalLoan(double loanAmount, double interestRate, String status, int tenureMonths, Customer customer, String purpose, String collateral) {
        // Validate all parameters using Helper class
        if (!Helper.isValidAmount(loanAmount) ||
                !Helper.isValidInterestRate(interestRate) ||
                !Helper.isValidLoanStatus(status) ||
                !Helper.isPositiveInt(tenureMonths) ||
                Helper.isObjectNull(customer) ||
                Helper.stringIsNullOrEmpty(purpose) ||
                Helper.stringIsNullOrEmpty(collateral)) {
            return null;
        }

        return new PersonalLoan.PersonalLoanBuilder()
                .setLoanAmount(loanAmount)
                .setInterestRate(interestRate)
                .setStatus(status)
                .setTenureMonths(tenureMonths)
                .setCustomer(customer)
                .setPurpose(purpose)
                .setCollateral(collateral)
                .build();
    }
}