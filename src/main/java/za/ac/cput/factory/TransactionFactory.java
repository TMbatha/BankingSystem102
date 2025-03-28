package za.ac.cput.factory;
/* Factory for creating Transaction objects
   Author: 222614153
*/


import za.ac.cput.domain.Transaction;
import za.ac.cput.util.Helper;

public class TransactionFactory {

    public static Transaction createDeposit(String transactionId, double amount, String date) {
        if (Helper.stringIsNullOrEmpty(transactionId) || amount <= 0 || Helper.stringIsNullOrEmpty(date)) {
            return null;
        }
        return new Transaction.Builder()
                .transactionId(transactionId)
                .amount(amount)
                .date(date)
                .type("DEPOSIT")
                .build();
    }

    public static Transaction createWithdrawal(String transactionId, double amount, String date) {
        if (Helper.stringIsNullOrEmpty(transactionId) || amount <= 0 || Helper.stringIsNullOrEmpty(date)) {
            return null;
        }
        return new Transaction.Builder()
                .transactionId(transactionId)
                .amount(amount)
                .date(date)
                .type("WITHDRAWAL")
                .build();
    }
}