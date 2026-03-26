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
        Account account = findAccount(accountId);
        account.deposit(amount);
        saveAccount(accountId, account);
    }

    @Override
    public void withdraw(String accountId, BigDecimal amount) {
        Account account = findAccount(accountId);
        account.withdraw(amount);
        saveAccount(accountId, account);
    }

    @Override
    public String printStatement(String accountId) {
        Account account = accountRepository.findById(accountId);
        return account.printStatement();
    }

    private Account findAccount(String accountId) {
        return accountRepository.findById(accountId);
    }

    private void saveAccount(String accountId, Account account) {
        accountRepository.save(accountId, account);
    }
}