package com.wsd.ecom.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(OrderDetailController.class)
@AutoConfigureMockMvc
public class OrderDetailControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnTotalSaleAmountOfToday() throws Exception {
        ResultActions response = mockMvc.perform(get("/api/order-detail/total-sale-amount-today")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.total", Matchers.greaterThanOrEqualTo(0.0)));
    }
}
