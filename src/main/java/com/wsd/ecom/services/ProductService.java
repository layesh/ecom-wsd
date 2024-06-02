package com.wsd.ecom.services;

import com.wsd.ecom.entities.Product;
import com.wsd.ecom.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getCustomerWishlist(long id) {
        return productRepository.getCustomerWishlist(id);
    }
}
