package za.ac.cput.repository;

import za.ac.cput.domain.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IAccountRepository {

    private static IAccountRepository repository = null;
    private List<Account> accountList;

    private AccountRepository() {
        accountList = new ArrayList<Account>();
        System.out.println("Account Repository Created Successfully");
    }

    public static IAccountRepository getRepository() {
        if (repository == null) {
            repository = new AccountRepository();
        }
        return repository;
    }

    @Override
    public Account add(Account account) {
        boolean success = accountList.add(account);
        if (success) {
            return account;
        }
        return null;
    }

    @Override
    public Account read(String accountNumber) {
        for (Account account : accountList) {
            if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public Account update(Account account) {
        String accountNumber = account.getAccountNumber();
        Account oldAccount = read(accountNumber);
        if (oldAccount == null) {
            return null;
        }

        boolean success = delete(accountNumber);
        if (success) {
            if (accountList.add(account)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String accountNumber) {
        Account accountToDelete = read(accountNumber);
        if (accountToDelete == null) {
            return false;
        }
        return accountList.remove(accountToDelete);
    }

    @Override
    public List<Account> getAll() {
        return accountList;
    }
}
