package com.banking.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private static final String STATEMENT_HEADER = "date       | amount   | balance\n";
    private static final String TRANSACTION_FORMAT = "%s | %8.2f | %8.2f%n";

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

    public String printStatement(){
        StringBuilder statement= new StringBuilder();
        statement.append(STATEMENT_HEADER);
        List<Transaction> reversed = new ArrayList<>(transactions);
        Collections.reverse(reversed);

        for (Transaction transaction : reversed) {
            statement.append(String.format(TRANSACTION_FORMAT,
                    transaction.date(),
                    transaction.amount(),
                    transaction.balance()
            ));
        }
        return statement.toString();
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