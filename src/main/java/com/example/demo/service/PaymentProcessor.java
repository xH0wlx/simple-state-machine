package com.example.demo.service;

import com.example.demo.domain.OrderData;
import com.example.demo.domain.OrderEvent;
import com.example.demo.domain.ProcessData;
import com.example.demo.exception.PaymentException;
import com.example.demo.exception.ProcessException;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessor implements Processor {
    @Override
    public ProcessData process(ProcessData data) throws ProcessException {
        if (((OrderData) data).getPayment() < 1.00) {
            ((OrderData) data).setEvent(OrderEvent.paymentError);
            throw new PaymentException(OrderEvent.paymentError.name());
        } else {
            ((OrderData) data).setEvent(OrderEvent.paymentSuccess);
        }
        return data;
    }
}
