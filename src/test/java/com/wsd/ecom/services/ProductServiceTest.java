package com.wsd.ecom.services;

import com.wsd.ecom.entities.Product;
import com.wsd.ecom.repositories.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void productService_givenCustomer_whenGetCustomer_thenReturnCustomerWishlist() {
        List<Product> inputProductList = Arrays.asList(
                new Product("Backpack", "Lightweight and slim", 100, 2000),
                new Product("Laptop", "Long Battery Life", 10, 60000)
        );

        when(productRepository.getCustomerWishlist(1)).thenReturn(inputProductList);

        List<Product> outputProductList = productService.getCustomerWishlist(1);

        Assertions.assertThat(outputProductList).isNotNull();
        Assertions.assertThat(outputProductList.size()).isEqualTo(2);
    }
}
