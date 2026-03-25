package com.banking.domain;

import com.banking.adapter.out.InMemoryAccountRepository;
import com.banking.domain.model.Account;
import com.banking.domain.port.in.AccountUseCase;
import com.banking.domain.port.out.AccountRepository;
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

    @Test
    void printStatement_shouldReturnFormattedTransactions() {
        Account account = new Account();
        account.deposit(new BigDecimal("500"));
        account.deposit(new BigDecimal("100"));
        account.withdraw(new BigDecimal("200"));


        String statement = account.printStatement();


        assertThat(statement).contains("date       | amount   | balance");
        assertThat(statement).contains("500,00");
        assertThat(statement).contains("100,00");
        assertThat(statement).contains("-200,00");
    }

    @Test
    void depositViaService_shouldIncreaseBalance() {

        AccountRepository repository = new InMemoryAccountRepository();
        AccountUseCase service = new AccountService(repository);


        service.deposit("account-1", new BigDecimal("1000"));


        Account account = repository.findById("account-1");
        assertThat(account.getBalance())
                .isEqualByComparingTo(new BigDecimal("1000"));
    }
}