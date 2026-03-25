package com.banking.domain.port.out;

import com.banking.domain.model.Account;

public interface AccountRepository {
    Account findById(String accountId);

}