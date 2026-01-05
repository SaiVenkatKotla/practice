package com.deloitte.parking.lot.bytebyte.serviceImpl;

import com.deloitte.parking.lot.bytebyte.serviceImpl.paymentStrategy.CashPayment;
import com.deloitte.parking.lot.bytebyte.serviceImpl.paymentStrategy.CreditCardPayment;
import com.deloitte.parking.lot.bytebyte.services.PaymentStrategy;

public class PaymentFactory {

    public PaymentStrategy getPaymentStrategy(String paymentType) {
        PaymentStrategy strategy = null;
        switch (paymentType) {
            case "CreditCard":
                strategy = new CreditCardPayment();
                break;
            default:
                strategy = new CashPayment();
        }
        return strategy;
    }
}
