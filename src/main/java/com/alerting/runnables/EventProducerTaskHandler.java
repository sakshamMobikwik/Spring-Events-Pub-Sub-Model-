package com.alerting.runnables;

import com.alerting.events.GenericEvent;
import org.springframework.context.ApplicationEventPublisher;

public class EventProducerTaskHandler implements Runnable{

    private ApplicationEventPublisher applicationEventPublisher;

    private GenericEvent alertEvent;

    public <T> EventProducerTaskHandler(T event, ApplicationEventPublisher publisher) {
       this.alertEvent = (GenericEvent) event;
       this.applicationEventPublisher = publisher;
    }

    @Override
    public void run() {
        this.applicationEventPublisher.publishEvent(alertEvent);

    }
}
