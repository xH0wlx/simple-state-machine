package com.example.demo.service;

import com.example.demo.domain.ProcessData;
import com.example.demo.exception.ProcessException;

public interface Processor {
    ProcessData process(ProcessData data) throws ProcessException;
}
