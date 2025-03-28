package za.ac.cput.factory;

import za.ac.cput.Domain.Customer;
import za.ac.cput.Domain.Loan;
import za.ac.cput.util.Helper;

public class LoanFactory {

    public static Loan createLoan(double interestRate, String status, int tenureMonths, double monthlyEMI, Customer customer) {
        if (!Helper.isValidInterestRate(interestRate) ||
                !Helper.isValidLoanStatus(status) ||
                !Helper.isPositiveInt(tenureMonths) ||
                !Helper.isValidAmount(monthlyEMI) ||
                customer == null) {
            return null;
        }

        return new Loan.LoanBuilder()
                .setInterestRate(interestRate)
                .setStatus(status)
                .setTenureMonths(tenureMonths)
                .setMonthlyEMI(monthlyEMI)
                .setCustomer(customer)
                .build();
    }
}