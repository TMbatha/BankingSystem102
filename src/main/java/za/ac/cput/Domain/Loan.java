/*Loan.java
 Loan pojo class
 Author: Lifa Mbangata (222558156)
 */

package za.ac.cput.Domain;


public abstract class Loan {

    private int loanID;
    private double loanAmount;
    private double interestRate;
    private String status;
    private int tenureMonths;
    private double monthlyEMI;
    private int customerID;

    protected Loan() {}

    // constructor that accepts a builder to set all fields
    protected Loan(LoanBuilder<?> builder) {
        this.loanID = builder.loanID;
        this.loanAmount = builder.loanAmount;
        this.interestRate = builder.interestRate;
        this.status = builder.status;
        this.tenureMonths = builder.tenureMonths;
        this.monthlyEMI = builder.monthlyEMI;
        this.customerID = builder.customerID;
    }

    //getter methods for each field
    public int getLoanID() {
        return loanID;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getStatus() {
        return status;
    }

    public int getTenureMonths() {
        return tenureMonths;
    }

    public double getMonthlyEMI() {
        return monthlyEMI;
    }

    public int getCustomerID() {
        return customerID;
    }

    //to striing to print loan details
    @Override
    public String toString() {
        return "Loan{" +
                "loanID=" + loanID +
                ", loanAmount=" + loanAmount +
                ", interestRate=" + interestRate +
                ", status='" + status + '\'' +
                ", tenureMonths=" + tenureMonths +
                ", monthlyEMI=" + monthlyEMI +
                ", customerID=" + customerID +
                '}';
    }

    // abstract builder class for Loan
    public abstract static class LoanBuilder<BuilderType extends LoanBuilder<BuilderType>> {
        private int loanID;
        private double loanAmount;
        private double interestRate;
        private String status;
        private int tenureMonths;
        private double monthlyEMI;
        private int customerID;

        // setters return correct builder type for method chaining
        public BuilderType setLoanID (int loanID) {
            this.loanID = loanID;
            return self();
        }
        public BuilderType setLoanAmount (double loanAmount) {
            this.loanAmount = loanAmount;
            return self();
        }
        public BuilderType setInterestRate (double interestRate) {
            this.interestRate = interestRate;
            return self();
        }
        public BuilderType setStatus (String status) {
            this.status = status;
            return self();
        }
        public BuilderType setTenureMonths (int tenureMonths) {
            this.tenureMonths = tenureMonths;
            return self();
        }
        public BuilderType setMonthlyEMI (double monthlyEMI) {
            this.monthlyEMI = monthlyEMI;
            return self();
        }
        public BuilderType setCustomerID (int customerID) {
            this.customerID = customerID;
            return self();
        }

        //method to copy attributes from an existing Loan object to the builder
        public BuilderType copy(Loan existingLoan) {
            this.loanID = existingLoan.getLoanID();
            this.loanAmount = existingLoan.getLoanAmount();
            this.interestRate = existingLoan.getInterestRate();
            this.status = existingLoan.getStatus();
            this.tenureMonths = existingLoan.getTenureMonths();
            this.monthlyEMI = existingLoan.getMonthlyEMI();
            this.customerID = existingLoan.getCustomerID();
            return self(); // return the current builder instance for method chaining
        }

        //abstract method to be implememted in subclasses
        protected abstract BuilderType self();

        //abstract method to build the final loan object
        public abstract Loan build();

    }
}
