package za.ac.cput.util;

public class Helper {
    public static boolean stringIsNullOrEmpty(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean intIsEqualsToZero(int i) {
        return i == 0;
    }

    public static boolean isValidEmail(String email) {
        // Placeholder for email validation logic
        return true; // Modify as needed
    }

    // New method to validate transaction amount
    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    // New method to validate transaction type
    public static boolean isValidTransactionType(String type) {
        return type.equalsIgnoreCase("DEPOSIT") || type.equalsIgnoreCase("WITHDRAWAL");
    }
}