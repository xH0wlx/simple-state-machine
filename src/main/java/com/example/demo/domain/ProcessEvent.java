package com.example.demo.domain;

import com.example.demo.service.Processor;

public interface ProcessEvent {
    Class<? extends Processor> nextStepProcessor(ProcessEvent event);
    ProcessState nextState(ProcessEvent event);
}
