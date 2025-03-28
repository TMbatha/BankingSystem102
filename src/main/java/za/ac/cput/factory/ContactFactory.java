package za.ac.cput.factory;
/*
Author: Thabiso Mbatha (221563423)
 */
import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

public class ContactFactory {
    private String phoneNumber, email;

    public static Contact createContact(String phoneNumber, String email){
        if(Helper.stringIsNullOrEmpty(phoneNumber) || !Helper.isValidEmail(email)){
            return null;
        }
        return new Contact.Builder().setPhoneNumber(phoneNumber).setEmail(email).build();
    }

}
