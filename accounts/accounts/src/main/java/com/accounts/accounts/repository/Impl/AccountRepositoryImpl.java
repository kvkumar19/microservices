package com.accounts.accounts.repository.Impl;

import com.accounts.accounts.entity.Account;
import com.accounts.accounts.repository.AccountRepository;
import com.accounts.accounts.repository.JPA.AccountJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    @Autowired
    private AccountJpaRepository jpaRepository;

    @Override
    public Account save(Account account) {
        return  jpaRepository.save(account) ;
    }

    @Override
    public List<Account> findAll() {
        return  jpaRepository.findAll();
    }

    @Override
    public Account getByUUId(String uuid) {
        return  jpaRepository.getByAccountUUId(uuid);
    }
}
