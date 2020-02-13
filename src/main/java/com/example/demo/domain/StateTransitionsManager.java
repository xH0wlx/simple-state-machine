package com.example.demo.domain;

import com.example.demo.exception.ProcessException;

public interface StateTransitionsManager {
    ProcessData processEvent(ProcessData data) throws ProcessException;
}
