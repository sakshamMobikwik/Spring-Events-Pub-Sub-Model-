package com.alerting.services;

import com.alerting.annotations.EventDelegation;
import com.alerting.interfaces.EventConsumerFunctionalInterface;
import com.alerting.wrappers.EventWrapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Service
public class EventDelegateService {

    public <T> void delegateToProcessor(Class c, T event) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        System.out.println("Inside processor delegation process");
        Method method = c.getDeclaredMethod("consume", Object.class);
        Method chala = null;
        if (method.isAnnotationPresent(EventDelegation.class)) {
            EventDelegation eventDelegation = method.getAnnotation(EventDelegation.class);
            Class targetProcessor = eventDelegation.targetProcessor();
            String targetMethod = eventDelegation.targetMethod();
            chala = c.getDeclaredMethod(targetMethod);
            chala.setAccessible(true);
            chala.invoke(c.newInstance());
            Object obj = targetProcessor.newInstance();
            EventWrapper eventWrapper = (EventWrapper) event;
            System.out.println(targetProcessor);
            Method targetProcessorMethod = obj.getClass().getMethod("handleEvent", eventWrapper.getClass());
            targetProcessorMethod.invoke(obj,eventWrapper);
       }
    }
}
