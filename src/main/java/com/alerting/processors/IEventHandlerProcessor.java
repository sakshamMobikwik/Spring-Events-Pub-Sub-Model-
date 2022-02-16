package com.alerting.processors;

import com.alerting.events.GenericEvent;
import com.alerting.wrappers.EventWrapper;

public interface IEventHandlerProcessor {
    public <T> void handleEvent(GenericEvent eventData);
}
