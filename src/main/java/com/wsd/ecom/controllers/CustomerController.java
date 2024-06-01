package com.wsd.ecom.controllers;

import com.wsd.ecom.entities.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest-api/customer")
public class CustomerController {
    @GetMapping("/{id}/wishlist")
    public List<Product> getCustomerWishList(@PathVariable long id) {
        return List.of(
                new Product("Backpack", "Lightweight and slim", 100, 2000),
                new Product("Laptop", "Long Battery Life", 10, 60000)
        );
    }
}
