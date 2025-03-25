package za.ac.cput.Domain;

public class Address {

    private String houseNumber, streetName, surburb, city, country;
    private int postalCode;

    private Address() {
    }

    private Address(Builder builder) {
        this.houseNumber = builder.houseNumber;
        this.streetName = builder.streetName;
        this.surburb = builder.surburb;
        this.city = builder.city;
        this.country = builder.country;
        this.postalCode = builder.postalCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSurburb() {
        return surburb;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber='" + houseNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", surburb='" + surburb + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }

    public static class Builder {
        private String houseNumber, streetName, surburb, city, country;
        private int postalCode;

        public Builder setHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setSurburb(String surburb) {
            this.surburb = surburb;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder copy(Address address){
            this.houseNumber = address.houseNumber;
            this.streetName = address.streetName;
            this.surburb = address.surburb;
            this.city = address.city;
            this.country = address.country;
            this.postalCode = address.postalCode;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }


}
