package com.example.demo.domain;

import com.example.demo.service.OrderProcessor;
import com.example.demo.service.PaymentProcessor;
import com.example.demo.service.Processor;

/**
 * DEFAULT    -  submit -> orderProcessor()   -> orderCreated   -> PMTPENDING
 * PMTPENDING -  pay    -> paymentProcessor() -> paymentError   -> PMTPENDING
 * PMTPENDING -  pay    -> paymentProcessor() -> paymentSuccess -> COMPLETED
 */
public enum OrderEvent implements ProcessEvent {

    submit {
        @Override
        public Class<? extends Processor> nextStepProcessor(ProcessEvent event) {
            return OrderProcessor.class;
        }

        /**
         * This event has no effect on state so return current state
         */
        @Override
        public ProcessState nextState(ProcessEvent event) {
            return OrderState.Default;
        }

    },
    orderCreated {
        /**
         * This event does not trigger any process
         * So return null
         */
        @Override
        public Class<? extends Processor> nextStepProcessor(ProcessEvent event) {
            return null;
        }

        @Override
        public ProcessState nextState(ProcessEvent event) {
            return OrderState.PaymentPending;
        }

    },
    pay {
        @Override
        public Class<? extends Processor> nextStepProcessor(ProcessEvent event) {
            return PaymentProcessor.class;
        }

        /**
         * This event has no effect on state so return current state
         */
        @Override
        public ProcessState nextState(ProcessEvent event) {
            return OrderState.PaymentPending;
        }
    },
    paymentSuccess {
        /**
         * This event does not trigger any process
         * So return null
         */
        @Override
        public Class<? extends Processor> nextStepProcessor(ProcessEvent event) {
            return null;
        }

        @Override
        public ProcessState nextState(ProcessEvent event) {
            return OrderState.Completed;
        }
    },
    paymentError {
        /**
         * This event does not trigger any process
         * So return null
         */
        @Override
        public Class<? extends Processor> nextStepProcessor(ProcessEvent event) {
            return null;
        }

        @Override
        public ProcessState nextState(ProcessEvent event) {
            return OrderState.PaymentPending;
        }
    },
    rejected {
        @Override
        public Class<? extends Processor> nextStepProcessor(ProcessEvent event) {
            return null;
        }

        @Override
        public ProcessState nextState(ProcessEvent event) {
            return OrderState.Default;
        }
    }
}
