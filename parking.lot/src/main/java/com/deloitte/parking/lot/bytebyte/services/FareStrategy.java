package com.deloitte.parking.lot.bytebyte.services;

import com.deloitte.parking.lot.bytebyte.serviceImpl.Ticket;

import java.math.BigDecimal;

public interface FareStrategy {
    BigDecimal calculateFare(Ticket ticket, BigDecimal inputFare);
}
