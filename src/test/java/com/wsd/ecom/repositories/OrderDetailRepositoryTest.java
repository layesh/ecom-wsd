package com.wsd.ecom.repositories;

import com.wsd.ecom.entities.Customer;
import com.wsd.ecom.entities.OrderDetail;
import com.wsd.ecom.entities.OrderItem;
import com.wsd.ecom.entities.Product;
import com.wsd.ecom.enums.PaymentStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class OrderDetailRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void givenCurrentDate_getTotalSale_returnAmount() {
        Instant now = Instant.now();
        Instant fromDate = now.atZone(ZoneId.of("UTC")).toInstant().truncatedTo(ChronoUnit.DAYS);
        Instant toDate = fromDate.plus(1, ChronoUnit.DAYS).minusSeconds(1);
        Customer customer = new Customer("Test", "Customer1", "testcustomer1@ecom-wsd.com",
                "+8801747885599", "Dhaka");
        customerRepository.save(customer);

        Product product = new Product("Backpack", "Lightweight and slim", 100, 2000);
        Product product1 = new Product("Laptop", "Long Battery Life", 10, 60000);
        productRepository.save(product);
        productRepository.save(product1);

        OrderDetail orderDetail = new OrderDetail(customer, 62000, PaymentStatus.Paid, now, now);
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(new OrderItem(orderDetail, product, 1, product.getPrice()));
        orderItemList.add(new OrderItem(orderDetail, product1, 1, product1.getPrice()));
        orderDetail.setOrderItemList(orderItemList);
        orderDetailRepository.save(orderDetail);

        double totalSaleTodayFromOrderItemList = orderDetail.getOrderItemList().stream().map(oi -> oi.getQuantity() *
                oi.getPrice()).mapToDouble(Double::doubleValue).sum();

        double totalSaleFromApi = orderDetailRepository.getTotalSaleInDateRange(fromDate, toDate);

        Assertions.assertThat(totalSaleFromApi).isEqualTo(totalSaleTodayFromOrderItemList);
    }
}
