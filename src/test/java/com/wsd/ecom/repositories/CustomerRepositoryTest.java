package com.wsd.ecom.repositories;

import com.wsd.ecom.entities.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void givenNewCustomer_whenSave_thenSuccess() {
        Customer customer = new Customer("Test", "Customer1", "testcustomer1@ecom-wsd.com",
                "+8801747885599", "Dhaka");
        Customer savedCustomer = customerRepository.save(customer);

        Assertions.assertThat(savedCustomer).isNotNull();
        Assertions.assertThat(savedCustomer.getId()).isGreaterThan(0);
    }
}
