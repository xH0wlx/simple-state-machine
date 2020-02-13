package com.example.demo.service;

import com.example.demo.domain.OrderState;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderDbService {

    private final ConcurrentHashMap<UUID, OrderState> states;

    public OrderDbService() {
        this.states = new ConcurrentHashMap<UUID, OrderState>();
    }

    public ConcurrentHashMap<UUID, OrderState> getStates() {
        return states;
    }
}
