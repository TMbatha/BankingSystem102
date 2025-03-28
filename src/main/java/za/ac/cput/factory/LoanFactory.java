/*Loan.java
Loan pojo class
Author: Lifa Mbangata (222558156)
*/

package za.ac.cput.factory;

import za.ac.cput.Domain.Customer;
import za.ac.cput.Domain.Loan;
import za.ac.cput.util.Helper;

public class LoanFactory {
    public static Loan createLoan(
            double loanAmount,
            double interestRate,
            String status,
            int tenureMonths,
            double monthlyEMI,
            Customer customer,
            String purpose,  // Changed to String
            String collateral // Changed to String
    ) {
        // Validate inputs
        if (!Helper.isValidAmount(loanAmount) ||
                !Helper.isValidInterestRate(interestRate) ||
                !Helper.isValidLoanStatus(status) ||
                !Helper.isPositiveInt(tenureMonths) ||
                !Helper.isValidAmount(monthlyEMI) ||
                Helper.isObjectNull(customer) ||
                Helper.stringIsNullOrEmpty(purpose) || // Validate purpose
                Helper.stringIsNullOrEmpty(collateral)) { // Validate collateral
            return null;
        }

        return new Loan.LoanBuilder()
                .setLoanAmount(loanAmount)
                .setInterestRate(interestRate)
                .setStatus(status)
                .setTenureMonths(tenureMonths)
                .setMonthlyEMI(monthlyEMI)
                .setCustomer(customer)
                .setPurpose(purpose)   // Pass String argument
                .setCollateral(collateral) // Pass String argument
                .build();
    }
}
