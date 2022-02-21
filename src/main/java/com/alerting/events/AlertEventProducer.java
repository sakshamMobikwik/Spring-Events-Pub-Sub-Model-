package com.alerting.events;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service("alertEventProducer")
public class AlertEventProducer extends AbstractEventProducer {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    private Logger logger = LogManager.getLogger(this.getClass());

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public <T> void produce(GenericEvent event) throws ClassNotFoundException {
       Class<?> c = Class.forName(event.getClass().getName());
       System.out.println(c.getName());
       logger.info("Event Produced : {}",event);
       applicationEventPublisher.publishEvent(event);
    }

}
