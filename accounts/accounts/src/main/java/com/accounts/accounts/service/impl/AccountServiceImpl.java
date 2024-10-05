package com.accounts.accounts.service.impl;

import com.accounts.accounts.dto.AccountDto;
import com.accounts.accounts.dto.GenerateRandom;
import com.accounts.accounts.dto.ResponseAccountDto;
import com.accounts.accounts.entity.Account;
import com.accounts.accounts.repository.AccountRepository;
import com.accounts.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public String saveAccountData(AccountDto accountDto) {
        String respons;
        Account account = dtoToEntity(accountDto);

        account.setCreatedBy("Vinay");
        account.setCreatedAt(LocalDateTime.now());
        Account save = repository.save(account);
        if (save != null) {
            respons = "You are Account saved successfully";
        } else respons = "You are Account failed successfully";

        return respons;
    }

    @Override
    public List<ResponseAccountDto> getAccountData() {
        return repository.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    public ResponseAccountDto getAccountByUUId(String uuid) {
        Account account = repository.getByUUId(uuid);
        return  mapToDto(account);
    }

    private Account dtoToEntity(AccountDto dto) {
        Account account = new Account();
        account.setAccountUUId(GenerateRandom.generateRandomNumber());
        account.setAccountNumber(GenerateRandom.generateAccountNumber());
        account.setAccountHolderName(dto.getAccountHolderName());
        account.setAccountType(dto.getAccountType());
        account.setBalance(dto.getBalance());
        return account;
    }

    private AccountDto entityToDto(Account entity) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountType(entity.getAccountType());
        accountDto.setBalance(entity.getBalance());
        accountDto.setAccountHolderName(entity.getAccountHolderName());
        return accountDto;
    }
    private  ResponseAccountDto mapToDto(Account account) {
        return new ResponseAccountDto(
                account.getAccountUUId(),
                account.getAccountNumber(),
                account.getAccountHolderName(),
                account.getBalance(),
                account.getAccountType(),
                account.getCreatedAt(),
                account.getCreatedBy(),
                account.getUpdatedAt(),
                account.getUpdatedBy()
        );
    }

}
