/*PersonalLoan.java
 PersonalLoan pojo class
 Author: Lifa Mbangata (222558156)
 */


package za.ac.cput.Domain;

public class PersonalLoan extends Loan {
    private String purpose; //Education, Medical, Travel
    private String collateral;
    public PersonalLoan(PersonalLoanBuilder builder) {
        super(builder); // call to the Loan constructor
        this.purpose = builder.purpose;
        this.collateral = builder.collateral;
    }
    //getter for new attributes
    public String getPurpose() {
        return purpose;
    }
    public String getCollateral() {
        return collateral;
    }
    @Override
    public String toString() {
        return super.toString() +
                "purpose='" + purpose + '\'' +
                ", collateral='" + collateral + '\'' +
                '}';
    }
    //personal builder class with the copy method
    public static class PersonalLoanBuilder extends LoanBuilder {
        private String purpose;
        private String collateral;
        //setters
        public PersonalLoanBuilder setPurpose (String purpose) {
            this.purpose = purpose;
            return this;
        }
        public PersonalLoanBuilder setCollateral (String collateral) {
            this.collateral = collateral;
            return this;
        }
        //copy method to duplicate an existing PersonalLoan object
        public PersonalLoanBuilder copy(PersonalLoan existingLoan) {
            this.purpose = existingLoan.getPurpose();
            this.collateral = existingLoan.getCollateral();
            this.setLoanAmount(existingLoan.getLoanAmount());
            this.setInterestRate(existingLoan.getInterestRate());
            this.setStatus(existingLoan.getStatus());
            this.setTenureMonths(existingLoan.getTenureMonths());
            this.setCustomer(existingLoan.getCustomer());
            return this;
        }
        //override the build() method to create the final PersonalLoan object
        @Override
        public PersonalLoan build() {
            return new PersonalLoan(this);
        }
    }
    }

