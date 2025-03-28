package za.ac.cput.util;

import org.apache.commons.validator.*;


public class Helper {
    public static boolean stringIsNullOrEmpty(String s) {
        if (s.isEmpty() || s == null) {
            return true;
        }
        return false;
    }

    public static boolean intIsEqualsToZero(int i) {
        if (i == 0) {
            return true;
        }
        return false;
    }

    public static boolean isValidEmail(String email) {
        /*EmailValidator validator = EmailValidator.getInstance();
        if (validator.isValid(email)) {
            return true;
        } else {
            return false;
        }*/
        return true;
    }


}
