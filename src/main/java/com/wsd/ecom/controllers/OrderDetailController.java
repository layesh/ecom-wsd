package com.wsd.ecom.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-detail")
public class OrderDetailController {
    @GetMapping("/total-sale-amount-today")
    public String totalSaleOfToday() {
        return "{total:0.0}";
    }
}
