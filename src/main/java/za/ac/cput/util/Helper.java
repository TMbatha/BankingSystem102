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


    // New method to validate transaction type
    public static boolean isValidTransactionType(String type) {
        return type.equalsIgnoreCase("DEPOSIT") || type.equalsIgnoreCase("WITHDRAWAL");
    }

    // NEW METHODS ADDED FOR LOAN VALIDATION
    public static boolean isValidLoanStatus(String status) {
        return status != null && (
                status.equalsIgnoreCase("approved") ||
                        status.equalsIgnoreCase("pending") ||
                        status.equalsIgnoreCase("rejected")
        );
    }

    public static boolean isPositiveInt(int value) {
        return value > 0;
    }

    public static boolean isValidInterestRate(double rate) {
        return rate > 0 && rate <= 20.0;
    }
    // NEW METHOD: Check if an object is null
    public static boolean isObjectNull(Object obj) {
        return obj == null;
    }

}
