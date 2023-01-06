package com.ocha.sample.keda.main;

import java.util.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class KafkaConsumerDemo {

    private final static Logger logger = Logger.getLogger(KafkaConsumerDemo.class.getSimpleName());

    @Incoming("keda-demo")
    public void consume(String payload) {
        logger.info("=======New Message Received!!=======");
        logger.info("message: " + payload);
        logger.info("=======Message Consumed!!=======");
    }
}
