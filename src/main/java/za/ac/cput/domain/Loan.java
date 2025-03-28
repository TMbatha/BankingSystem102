/*Loan.java
Loan pojo class
Author: Lifa Mbangata (222558156)
*/

package za.ac.cput.domain;

public class Loan {


    private double loanAmount;
    private double interestRate;
    private String status;
    private int tenureMonths;
    private double monthlyEMI;
    private Customer customer;
    private String purpose;
    private String collateral;



    protected Loan() {}
    // constructor that accepts a builder to set all fields
    protected Loan(LoanBuilder builder) {

        this.loanAmount = builder.loanAmount;
        this.interestRate = builder.interestRate;
        this.status = builder.status;
        this.tenureMonths = builder.tenureMonths;
        this.monthlyEMI = builder.monthlyEMI;
        this.customer = builder.customer;
        this.purpose = builder.purpose;
        this.collateral = builder.collateral;

    }
    //getter methods for each field

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
    public Customer getCustomer() {
        return customer;
    }
    public String getPurpose() {
        return purpose;
    }
    public String getCollateral() {
        return collateral;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanAmount=" + loanAmount +
                ", interestRate=" + interestRate +
                ", status='" + status + '\'' +
                ", tenureMonths=" + tenureMonths +
                ", monthlyEMI=" + monthlyEMI +
                ", customer=" + customer +
                ", purpose='" + purpose + '\'' +
                ", collateral='" + collateral + '\'' +
                '}';
    }

    // abstract builder class for Loan
    public static class LoanBuilder {

        private double loanAmount;
        private double interestRate;
        private String status;
        private int tenureMonths;
        private double monthlyEMI;
        private Customer customer;
        private String purpose;
        private String collateral;

        public LoanBuilder setLoanId(String loanId) {
            //this.loanId = loanId;
            return this;
        }
        public LoanBuilder setLoanAmount (double loanAmount) {
            this.loanAmount = loanAmount;
            return this;
        }
        public LoanBuilder setInterestRate (double interestRate) {
            this.interestRate = interestRate;
            return this;
        }
        public LoanBuilder setStatus (String status) {
            this.status = status;
            return this;
        }
        public LoanBuilder setTenureMonths (int tenureMonths) {
            this.tenureMonths = tenureMonths;
            return this;
        }
        public LoanBuilder setMonthlyEMI (double monthlyEMI) {
            this.monthlyEMI = monthlyEMI;
            return this;
        }
        public LoanBuilder setCustomer (Customer customer) {
            this.customer = customer;
            return this;
        }
        public LoanBuilder setPurpose (String purpose) {
            this.purpose = purpose;
            return this;
        }
        public LoanBuilder setCollateral (String collateral) {
            this.collateral = collateral;
            return this;
        }
        //method to copy attributes from an existing Loan object to the builder
        public LoanBuilder copy(Loan existingLoan) {
            this.loanAmount = existingLoan.getLoanAmount();
            this.interestRate = existingLoan.getInterestRate();
            this.status = existingLoan.getStatus();
            this.tenureMonths = existingLoan.getTenureMonths();
            this.monthlyEMI = existingLoan.getMonthlyEMI();
            this.customer = existingLoan.getCustomer();
            this.purpose = existingLoan.getPurpose();
            this.collateral = existingLoan.getCollateral();
            return this; // return the current builder instance for method chaining
        }
        //abstract method to build the final loan object
        public Loan build(){
            return new Loan(this);
        }

        /*public PersonalLoan.PersonalLoanBuilder setPurpose(String purpose) {

        }*/
    }
}
