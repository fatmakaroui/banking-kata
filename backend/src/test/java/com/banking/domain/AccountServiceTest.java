package com.banking.domain;

import com.banking.domain.model.Account;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class AccountServiceTest {

    @Test
    void deposit_shouldIncreaseBalance() {
        Account account = new Account();

        account.deposit(new BigDecimal("1000"));


        assertThat(account.getBalance())
                .isEqualByComparingTo(new BigDecimal("1000"));
    }

    @Test
    void withdraw_shouldDecreaseBalance() {
        Account account = new Account();
        account.deposit(new BigDecimal("1000"));

        account.withdraw(new BigDecimal("500"));

        assertThat(account.getBalance())
                .isEqualByComparingTo(new BigDecimal("500"));
    }
}