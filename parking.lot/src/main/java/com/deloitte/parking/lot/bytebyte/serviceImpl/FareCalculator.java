package com.deloitte.parking.lot.bytebyte.serviceImpl;

import com.deloitte.parking.lot.bytebyte.services.FareStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FareCalculator {
    private final List<FareStrategy> fareStrategyList;

    public FareCalculator(List<FareStrategy> fareStrategyList) {
        this.fareStrategyList = fareStrategyList;
    }

    public BigDecimal calculateFare(Ticket ticket) {
        BigDecimal fare = BigDecimal.ZERO;
        for (FareStrategy fareStrategy : fareStrategyList) {
            fare = fareStrategy.calculateFare(ticket, fare);
        }
        return fare;
    }
}
