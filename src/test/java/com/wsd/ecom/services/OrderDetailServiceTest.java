package com.wsd.ecom.services;

import com.wsd.ecom.repositories.OrderDetailRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderDetailServiceTest {
    @Mock
    OrderDetailRepository orderDetailRepository;

    @InjectMocks
    OrderDetailService orderDetailService;

    @Test
    public void orderDetailService_givenCurrentDate_whenGetCurrentDaySale_thenReturnTotalSaleAmount() {
        Instant now = Instant.now();
        Instant fromDate = now.atZone(ZoneId.of("UTC")).toInstant().truncatedTo(ChronoUnit.DAYS);
        Instant toDate = fromDate.plus(1, ChronoUnit.DAYS).minusSeconds(1);
        double saleAmount = 62000.0;

        when(orderDetailRepository.getTotalSaleInDateRange(fromDate, toDate)).thenReturn(saleAmount);
        double amount = orderDetailService.getTotalSaleInDateRange(fromDate, toDate);
        Assertions.assertThat(saleAmount).isEqualTo(amount);
    }
}
