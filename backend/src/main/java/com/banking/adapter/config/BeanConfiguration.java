package com.banking.adapter.config;

import com.banking.adapter.out.InMemoryAccountRepository;
import com.banking.domain.port.in.AccountUseCase;
import com.banking.domain.port.out.AccountRepository;
import com.banking.domain.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public AccountRepository accountRepository() {
        return new InMemoryAccountRepository();
    }

    @Bean
    public AccountUseCase accountUseCase(AccountRepository accountRepository) {
        return new AccountService(accountRepository);
    }
}