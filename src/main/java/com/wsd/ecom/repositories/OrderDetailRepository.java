package com.wsd.ecom.repositories;

import com.wsd.ecom.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query("SELECT od.totalAmount "
            + "FROM OrderDetail od "
            + "WHERE od.paymentStatus = 'Paid' "
            + "AND od.dateUpdated BETWEEN :fromDate AND :toDate")
    Double getTotalSaleInDateRange(@Param("fromDate") Instant fromDate, @Param("toDate") Instant toDate);
}
