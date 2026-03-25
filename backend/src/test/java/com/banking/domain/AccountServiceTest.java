package com.banking.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AccountServiceTest {

    @Test
    void deposit_shouldIncreaseBalance() {
        Account account = new Account();

        account.deposit(new java.math.BigDecimal("1000"));


        assertThat(account.getBalance())
                .isEqualByComparingTo(new java.math.BigDecimal("1000"));
    }
}