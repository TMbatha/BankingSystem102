package za.ac.cput.util;

import java.time.LocalDate;
import za.ac.cput.Domain.Customer;

public class Helper {

    public static boolean stringIsNullOrEmpty(String value) {
        if(value.isEmpty() || value == null || value.equals("")){
            return true;
        }
        return false;
    }

    public static boolean intIsEqualsToZero(int value) {
        if(value == 0){
            return true;
        }
        return false;
    }

    public static boolean isValidEmail(String email) {
        //To-Do
        return true;
    }
}
