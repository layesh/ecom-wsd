package com.wsd.ecom.controllers;

import com.wsd.ecom.services.OrderDetailService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Instant;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(OrderDetailController.class)
@AutoConfigureMockMvc
public class OrderDetailControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderDetailService orderDetailService;

    @Test
    public void shouldReturnTotalSaleAmountOfToday() throws Exception {
        Instant now = Instant.now();
        double totalSaleToday = 62000.0;
        when(orderDetailService.getTotalSaleInDateRange(any(), any())).thenReturn(totalSaleToday);

        ResultActions response = mockMvc.perform(get("/api/order-detail/total-sale-amount-today")
                .contentType(MediaType.APPLICATION_JSON));
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.total", Matchers.is(totalSaleToday)));
    }
}
