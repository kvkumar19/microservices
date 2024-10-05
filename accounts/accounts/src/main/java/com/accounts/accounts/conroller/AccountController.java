package com.accounts.accounts.conroller;

import com.accounts.accounts.dto.AccountDto;
import com.accounts.accounts.dto.ResponseAccountDto;
import com.accounts.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping()
    public ResponseEntity<String> saveAccount(@RequestBody AccountDto accountDto) {
        String response = accountService.saveAccountData(accountDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping()
    public List<ResponseAccountDto> getAllAccounts() {
        return accountService.getAccountData();
    }
    @GetMapping("/{uuid}")
    public  ResponseEntity<ResponseAccountDto> getById(@PathVariable("uuid")  String uuid){
        ResponseAccountDto response = accountService.getAccountByUUId(uuid);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
