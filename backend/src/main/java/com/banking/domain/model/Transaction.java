package com.banking.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Transaction(
        LocalDate date,
        BigDecimal amount,
        BigDecimal balance
) {}
