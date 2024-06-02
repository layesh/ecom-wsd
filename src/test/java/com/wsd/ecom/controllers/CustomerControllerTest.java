package com.wsd.ecom.controllers;

import com.wsd.ecom.entities.Product;
import com.wsd.ecom.services.ProductService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void shouldReturnCustomerWishlist() throws Exception {
        when(productService.getCustomerWishlist(1)).thenReturn(List.of(
                new Product("Backpack", "Lightweight and slim", 100, 2000),
                new Product("Laptop", "Long Battery Life", 10, 60000)
        ));

        ResultActions resultActions = mockMvc.perform(get("/rest-api/customer/1/wishlist").contentType(
                MediaType.APPLICATION_JSON));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.
                jsonPath("$", Matchers.hasSize(2)));
    }
}
