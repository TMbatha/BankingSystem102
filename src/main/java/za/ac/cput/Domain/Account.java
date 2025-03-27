package za.ac.cput.Domain;

import java.time.LocalDate;
public class Account {
    private String accountNumber; // Primary Key
    private double balance;
    private LocalDate openDate;

    public Account() {
    }

    // Constructor using Builder Pattern
    public Account(Builder builder) {
        this.accountNumber = builder.accountNumber;
        this.balance = builder.balance;
        this.openDate = builder.openDate;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", openDate=" + openDate +
                '}';
    }

    // Builder Pattern for constructing Account objects
    public static class Builder {
        private String accountNumber;
        private double balance;
        private LocalDate openDate;

        public Builder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder setOpenDate(LocalDate openDate) {
            this.openDate = openDate;
            return this;
        }


        public Builder copy(Account account) {
            this.accountNumber = account.accountNumber;
            this.balance = account.balance;
            this.openDate = account.openDate;

            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
