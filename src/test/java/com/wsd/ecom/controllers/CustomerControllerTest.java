package com.wsd.ecom.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void returnCustomerWishlist() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/rest-api/customer/1/wishlist").contentType(
                MediaType.APPLICATION_JSON));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.
                jsonPath("$", Matchers.hasSize(1)));
    }
}
