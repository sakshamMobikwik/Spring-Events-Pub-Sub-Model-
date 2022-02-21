package com.alerting.events;

import com.alerting.annotations.EventDelegation;
import com.alerting.processors.SuspiciousAlertEventProcessor;
import com.alerting.services.EventDelegateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service("alertEventConusmer")

public class AlertEventConsumer extends AbstractEventConsumer implements ApplicationListener<LoginEvent> {

    @Autowired
    private EventDelegateService eventDelegateService;

    private Logger logger = LogManager.getLogger(this.getClass());


    @Override
    public void onApplicationEvent(LoginEvent event) {
        try {
            System.out.println("Blocking Thread for eventType : "+event.getEventType());
            Thread.sleep(4000);
            System.out.println("Event Consumed");
            this.consume(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void chala() {
        System.out.println("Chala Function Invoked Successfully");
    }

    @Override
    public <T> void consume(GenericEvent event) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        System.out.println("Inside consume function");
    }
}
