package com.wsd.ecom.services;

import com.wsd.ecom.repositories.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public Double getTotalSaleInDateRange(Instant fromDate, Instant toDate) {
        Double totalSale = orderDetailRepository.getTotalSaleInDateRange(fromDate, toDate);
        return totalSale != null ? totalSale : 0.0;
    }
}
