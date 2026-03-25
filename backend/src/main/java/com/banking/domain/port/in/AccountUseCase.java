package com.banking.domain.port.in;

import java.math.BigDecimal;

public interface AccountUseCase {
    void deposit(String accountId, BigDecimal amount);
    void withdraw(String accountId, BigDecimal amount);
    String printStatement(String accountId);
}