package com.wsd.ecom.controllers;

import com.wsd.ecom.services.OrderDetailService;
import com.wsd.ecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/order-detail")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("/total-sale-amount-today")
    public String totalSaleOfToday() {
        Instant now = Instant.now();
        Instant fromDate = now.atZone(ZoneId.of("UTC")).toInstant().truncatedTo(ChronoUnit.DAYS);
        Instant toDate = fromDate.plus(1, ChronoUnit.DAYS).minusSeconds(1);

        Double totalSaleToday = orderDetailService.getTotalSaleInDateRange(fromDate, toDate);
        return "{total:" + totalSaleToday.toString() + "}";
    }
}
