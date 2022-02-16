package com.alerting.interfaces;

import java.lang.reflect.InvocationTargetException;

@FunctionalInterface
public interface EventConsumerFunctionalInterface {
    public <T> void consume(T event) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
