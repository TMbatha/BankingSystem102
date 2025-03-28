package za.ac.cput.repository;

import za.ac.cput.domain.Account;

import java.util.List;

public interface IAccountRepository extends IRepository<Account, String>{
    List<Account> getAll();
    }

