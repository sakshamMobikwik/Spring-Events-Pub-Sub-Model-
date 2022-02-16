package com.alerting.events;

public abstract class AbstractEventProducer {
    public abstract <T> void produce(T event);
}
