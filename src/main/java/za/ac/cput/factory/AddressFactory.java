package za.ac.cput.factory;

import za.ac.cput.Domain.Address;
import za.ac.cput.util.Helper;

public class AddressFactory {

    public static Address createShortAddress(String houseNumber, String streetName, String suburb){
        if(Helper.stringIsNullOrEmpty(houseNumber) || Helper.stringIsNullOrEmpty(streetName) || Helper.stringIsNullOrEmpty(suburb)){
            return null;
        }
        return new Address.Builder().setHouseNumber(houseNumber).setStreetName(streetName).setSuburb(suburb).build();
    }

    public static Address createFullAddress(String houseNumber,String streetName,String suburb,String city,String country, int postalCode){
        if(Helper.stringIsNullOrEmpty(houseNumber) ||
                Helper.stringIsNullOrEmpty(streetName) ||
                Helper.stringIsNullOrEmpty(suburb) ||
                Helper.stringIsNullOrEmpty(city) ||
                Helper.stringIsNullOrEmpty(country) ||
                Helper.intIsEqualsToZero(postalCode)){
            return null;
        }
        return new Address.Builder().setHouseNumber(houseNumber).setStreetName(streetName).setSuburb(suburb).setCity(city).setCountry(country).setPostalCode(postalCode).build();
    }

}
