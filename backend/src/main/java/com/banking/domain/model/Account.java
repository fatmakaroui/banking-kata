package com.banking.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;
    private final List<Transaction> transactions = new ArrayList<>();

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        addTransaction(amount);
    }

    public void withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
        addTransaction(amount.negate());
    }

    private void addTransaction(BigDecimal amount) {
        transactions.add(new Transaction(LocalDate.now(), amount, balance));
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}