package com.banking.adapter.in;

import com.banking.domain.port.in.AccountUseCase;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountUseCase accountUseCase;

    public AccountController(AccountUseCase accountUseCase) {
        this.accountUseCase = accountUseCase;
    }

    @PostMapping("/{accountId}/deposit")
    public void deposit(@PathVariable String accountId,
                        @RequestParam BigDecimal amount) {
        accountUseCase.deposit(accountId, amount);
    }

    @PostMapping("/{accountId}/withdraw")
    public void withdraw(@PathVariable String accountId,
                        @RequestParam BigDecimal amount) {
        accountUseCase.withdraw(accountId, amount);
    }
}