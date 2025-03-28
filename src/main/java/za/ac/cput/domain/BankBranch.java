package za.ac.cput.domain;

public class BankBranch {
    private String branchName;
    private Address branchAddress;
    private Contact branchContact;

    private BankBranch(){}

    private BankBranch(Builder builder){
        this.branchName = builder.branchName;
        this.branchAddress = builder.branchAddress;
        this.branchContact = builder.branchContact;
    }

    public String getBranchName() {
        return branchName;
    }

    public Address getBranchAddress() {
        return branchAddress;
    }

    public Contact getBranchContact() {
        return branchContact;
    }

    @Override
    public String toString() {
        return "BankBranch{" +
                "branchName='" + branchName + '\'' +
                ", branchAddress=" + branchAddress +
                ", branchContact=" + branchContact +
                '}';
    }

    public static class Builder{
        private String branchName;
        private Address branchAddress;
        private Contact branchContact;

        public Builder setBranchName(String branchName) {
            this.branchName = branchName;
            return this;
        }

        public Builder setBranchAddress(Address branchAddress) {
            this.branchAddress = branchAddress;
            return this;
        }

        public Builder setBranchContact(Contact branchContact) {
            this.branchContact = branchContact;
            return this;
        }

        public Builder copy(BankBranch bankBranch){
            this.branchName = bankBranch.branchName;
            this.branchAddress = bankBranch.branchAddress;
            this.branchContact = bankBranch.branchContact;
            return this;
        }

        public BankBranch build(){
            return new BankBranch(this);
        }
    }
}
