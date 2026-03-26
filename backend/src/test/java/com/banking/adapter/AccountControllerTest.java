package com.banking.adapter;

import com.banking.domain.port.in.AccountUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

        verify(accountUseCase).deposit("account-1", new java.math.BigDecimal("1000"));
    }
}