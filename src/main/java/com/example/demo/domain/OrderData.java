package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderData implements ProcessData {
    private double payment;
    private ProcessEvent event;
    private UUID orderId;

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public void setEvent(ProcessEvent event) {
        this.event = event;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    @Override
    public ProcessEvent getEvent() {
        return this.event;
    }
}
