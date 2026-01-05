package com.deloitte.parking.lot.bytebyte.serviceImpl.farestrategy;

import com.deloitte.parking.lot.bytebyte.services.FareStrategy;
import com.deloitte.parking.lot.bytebyte.serviceImpl.Ticket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PeakFareStrategy implements FareStrategy {
    private static final BigDecimal PEAK_HOUR_MULTIPLIER = new BigDecimal("1.5");

    public PeakFareStrategy() {
    }


    @Override
    public BigDecimal calculateFare(Ticket ticket, BigDecimal inputFare) {
        BigDecimal fare = inputFare;
        if (isPeak(ticket.getEntryTime())) {
            fare = fare.multiply(PEAK_HOUR_MULTIPLIER);
        }
        return fare;
    }

    private boolean isPeak(LocalDateTime time) {
        int hour = time.getHour();
        return hour >= 10 && hour <= 13;
    }
}
