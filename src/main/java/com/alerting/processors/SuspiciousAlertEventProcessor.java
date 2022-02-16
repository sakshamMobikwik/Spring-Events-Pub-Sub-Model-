package com.alerting.processors;


import com.alerting.events.GenericEvent;
import com.alerting.wrappers.EventWrapper;

public class SuspiciousAlertEventProcessor implements IEventHandlerProcessor {

    @Override
    public <T> void handleEvent(GenericEvent eventData) {
        System.out.println("Handle Event Invoked for Suspicious Login Alert Event Processor");
        if (eventData instanceof GenericEvent) {
            GenericEvent alertEvent = (GenericEvent) eventData;
            System.out.println("Ip : "+alertEvent.getData().getIp());
            System.out.println("Location : "+alertEvent.getData().getLocation());
            System.out.println("Username : "+alertEvent.getData().getUsername());
        }
    }
}
