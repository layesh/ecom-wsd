package com.wsd.ecom.controllers;

import com.wsd.ecom.entities.Product;
import com.wsd.ecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest-api/customer")
public class CustomerController {
    @Autowired
    ProductService productService;

    @GetMapping("/{id}/wishlist")
    public List<Product> getCustomerWishList(@PathVariable long id) {
        return productService.getCustomerWishlist(id);
    }
}
