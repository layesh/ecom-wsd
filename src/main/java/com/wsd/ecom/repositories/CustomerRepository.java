package com.wsd.ecom.repositories;

import com.wsd.ecom.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
