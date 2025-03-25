package za.ac.cput.Domain;

public class Customer {
    private String customerName, customerSurname;
    private Address customerAddress;
    private Contact customerContact;

    private Customer(){}

    private Customer(Builder builder){
        this.customerName = builder.customerName;
        this.customerSurname = builder.customerSurname;
        this.customerAddress = builder.customerAddress;
        this.customerContact = builder.customerContact;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public Address getCustomerAddress() {
        return customerAddress;
    }

    public Contact getCustomerContact() {
        return customerContact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerSurname='" + customerSurname + '\'' +
                ", customerAddress=" + customerAddress +
                ", customerContact=" + customerContact +
                '}';
    }

    public static class Builder{
        private String customerName, customerSurname;
        private Address customerAddress;
        private Contact customerContact;

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setCustomerSurname(String customerSurname) {
            this.customerSurname = customerSurname;
            return this;
        }

        public Builder setCustomerAddress(Address customerAddress) {
            this.customerAddress = customerAddress;
            return this;
        }

        public Builder setCustomerContact(Contact customerContact) {
            this.customerContact = customerContact;
            return this;
        }

        public Builder copy(Customer customer){
            this.customerName = customer.customerName;
            this.customerSurname = customer.customerSurname;
            this.customerAddress = customer.customerAddress;
            this.customerContact = customer.customerContact;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }
}
