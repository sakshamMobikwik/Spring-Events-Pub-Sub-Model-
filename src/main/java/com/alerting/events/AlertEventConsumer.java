package com.alerting.events;

import com.alerting.annotations.EventDelegation;
import com.alerting.processors.SuspiciousAlertEventProcessor;
import com.alerting.services.EventDelegateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Component("alertEventConusmer")
public class AlertEventConsumer extends AbstractEventConsumer implements ApplicationListener<GenericEvent> {

    @Autowired
    private EventDelegateService eventDelegateService;

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    @EventDelegation(targetProcessor = SuspiciousAlertEventProcessor.class,targetMethod = "chala")
    public <T> void consume(T event) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        logger.info("Event Consumed : {}",event);
        this.eventDelegateService.delegateToProcessor(this.getClass(), event);
    }

    @Override
    public void onApplicationEvent(GenericEvent event) {
        try {
            System.out.println("Event Consumed");
            this.consume(event);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
    private void chala() {
        System.out.println("Chala Function Invoked Successfully");
    }
}
