package com.banking.domain.service;

import com.banking.domain.model.Account;
import com.banking.domain.port.in.AccountUseCase;
import com.banking.domain.port.out.AccountRepository;

import java.math.BigDecimal;

public class AccountService implements AccountUseCase {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void deposit(String accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId);
        account.deposit(amount);
        accountRepository.save(accountId, account);
    }

    @Override
    public void withdraw(String accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId);
        account.withdraw(amount);
        accountRepository.save(accountId, account);
    }

    @Override
    public String printStatement(String accountId) {
        Account account = accountRepository.findById(accountId);
        return account.printStatement();
    }
}