package com.deloitte.parking.lot.bytebyte.services;

import java.math.BigDecimal;

public interface PaymentStrategy {
    public void processPayment(BigDecimal fare);
}
