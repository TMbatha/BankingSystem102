package za.ac.cput.domain;

/* Represents a financial transaction in the banking system
   Author: 222614153
*/


public class Transaction {
    private final String transactionId;
    private final double amount;
    private final String date;
    private final String type;

    private Transaction(Builder builder) {
        this.transactionId = builder.transactionId;
        this.amount = builder.amount;
        this.date = builder.date;
        this.type = builder.type;
    }

    // Getters
    public String getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return String.format(
                "%s{id='%s', amount=R%.2f, date='%s'}",
                type, transactionId, amount, date
        );
    }

    public static class Builder {
        private String transactionId;
        private double amount;
        private String date;
        private String type;

        public Builder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}