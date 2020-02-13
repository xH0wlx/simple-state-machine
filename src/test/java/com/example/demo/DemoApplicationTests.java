package com.example.demo;

import com.example.demo.domain.OrderData;
import com.example.demo.domain.OrderEvent;
import com.example.demo.domain.OrderStateTransitionsManager;
import com.example.demo.exception.ProcessException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private OrderStateTransitionsManager stateTrasitionsManager;

    @Test
    void test() throws ProcessException {
        OrderData data = new OrderData();
        data.setPayment(1234);
        data.setEvent(OrderEvent.pay);
        data = (OrderData) stateTrasitionsManager.processEvent(data);

        System.out.println( ((OrderEvent) data.getEvent()).name() + ", orderId = " + data.getOrderId() );
    }

}
