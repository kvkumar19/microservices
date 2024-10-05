package com.accounts.accounts.service;

import com.accounts.accounts.dto.AccountDto;
import com.accounts.accounts.dto.ResponseAccountDto;

import java.util.List;

public interface AccountService {

    String saveAccountData(AccountDto accountDto );
    List<ResponseAccountDto> getAccountData();
    ResponseAccountDto getAccountByUUId(String uuid);

}
