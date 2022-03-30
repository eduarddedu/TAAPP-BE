package com.tsn.taapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@AutoConfigureMockMvc
public class MockMvcHealthCheckTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getHealthCheck() throws Exception {
        this.mockMvc.perform(get("/health-check")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string("I am working"));
    }
}
