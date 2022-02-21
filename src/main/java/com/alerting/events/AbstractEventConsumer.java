package com.alerting.events;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractEventConsumer {
    public abstract <T> void consume(GenericEvent event) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException;

}
