package com.banking.adapter;

import com.banking.adapter.in.AccountController;
import com.banking.domain.port.in.AccountUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigDecimal;



import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AccountUseCase accountUseCase;

    @Test
    void deposit_shouldReturn200() throws Exception {
        mockMvc.perform(post("/accounts/account-1/deposit")
                        .param("amount", "1000"))
                .andExpect(status().isOk());

        verify(accountUseCase).deposit("account-1", new BigDecimal("1000"));
    }

    @Test
    void withdraw_shouldReturn200() throws Exception {
        mockMvc.perform(post("/accounts/account-1/withdraw")
                        .param("amount", "500"))
                .andExpect(status().isOk());

        verify(accountUseCase).withdraw("account-1", new BigDecimal("500"));
    }

    @Test
    void printStatement_shouldReturn200() throws Exception {
        when(accountUseCase.printStatement("account-1"))
                .thenReturn("date       | amount   | balance\n");

        mockMvc.perform(get("/accounts/account-1/statement"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("date       | amount   | balance")));
    }
}