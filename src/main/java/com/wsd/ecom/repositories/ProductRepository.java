package com.wsd.ecom.repositories;

import com.wsd.ecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT wl.product FROM Wishlist wl WHERE wl.customer.id = :customerId")
    List<Product> getCustomerWishlist(@Param("customerId") long customerId);
}
