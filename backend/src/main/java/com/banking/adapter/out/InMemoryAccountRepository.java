package com.banking.adapter.out;

import com.banking.domain.model.Account;
import com.banking.domain.port.out.AccountRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {

    private final Map<String, Account> store = new HashMap<>();

    @Override
    public Account findById(String accountId) {
        return store.getOrDefault(accountId, new Account());
    }
}