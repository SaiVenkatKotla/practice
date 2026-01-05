package com.deloitte.parking.lot.bytebyte.serviceImpl.paymentStrategy;

import com.deloitte.parking.lot.bytebyte.services.PaymentStrategy;

import java.math.BigDecimal;

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void processPayment(BigDecimal fare) {
        System.out.println("paid through Card");
    }
}
