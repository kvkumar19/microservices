package com.accounts.accounts.repository;

import com.accounts.accounts.entity.Account;

import java.util.List;

public interface AccountRepository {

    Account  save(Account account);
    List<Account> findAll();
    Account getByUUId(String uuid);

}
