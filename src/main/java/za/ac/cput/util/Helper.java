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