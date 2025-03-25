package za.ac.cput.Domain;

public class Contact {
    private String phoneNumber, email;

    public Contact(){}

    public Contact(Builder builder){
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder{
        private String phoneNumber, email;

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder copy(Contact contact){
            this.phoneNumber = contact.phoneNumber;
            this.email = contact.email;
            return this;
        }

        public Contact build(){
            return new Contact(this);
        }

    }


}
