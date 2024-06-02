package com.wsd.ecom.repositories;

import com.wsd.ecom.entities.Customer;
import com.wsd.ecom.entities.Product;
import com.wsd.ecom.entities.Wishlist;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class WishlistRepositoryTest {
    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void givenNewWishlist_whenSave_thenSuccess() {
        Customer customer = new Customer("Test", "Customer1", "testcustomer1@ecom-wsd.com",
                "+8801747885599", "Dhaka");
        Customer savedCustomer = customerRepository.save(customer);

        Product product = new Product("Backpack", "Lightweight and slim", 100, 2000);
        Product savedProduct = productRepository.save(product);

        Wishlist wishlist = new Wishlist(savedCustomer, savedProduct);
        Wishlist savedwishlist = wishlistRepository.save(wishlist);

        Assertions.assertThat(savedwishlist).isNotNull();
        Assertions.assertThat(savedwishlist.getId()).isGreaterThan(0);
    }

    @Test
    public void givenCustomer_whenGetCustomer_thenReturnCustomerWishlist() {
        Customer customer = new Customer("Test", "Customer1", "testcustomer1@ecom-wsd.com",
                "+8801747885599", "Dhaka");
        customerRepository.save(customer);

        Product product = new Product("Backpack", "Lightweight and slim", 100, 2000);
        Product product1 = new Product("Laptop", "Long Battery Life", 10, 60000);
        productRepository.save(product);
        productRepository.save(product1);

        Wishlist wishlist = new Wishlist(customer, product);
        Wishlist wishlist1 = new Wishlist(customer, product1);
        wishlistRepository.save(wishlist);
        wishlistRepository.save(wishlist1);

        List<Product> customerWishlist = productRepository.getCustomerWishlist(customer.getId());

        Assertions.assertThat(customerWishlist).isNotNull();
        Assertions.assertThat(customerWishlist.size()).isEqualTo(2);
    }
}
