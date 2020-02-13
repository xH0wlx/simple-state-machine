package com.example.demo.service;

import com.example.demo.domain.OrderData;
import com.example.demo.domain.OrderEvent;
import com.example.demo.domain.ProcessData;
import com.example.demo.exception.ProcessException;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessor implements Processor {
    @Override
    public ProcessData process(ProcessData data) throws ProcessException {
        ((OrderData) data).setEvent(OrderEvent.orderCreated);
        return data;
    }
}
