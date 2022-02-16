package com.alerting.wrappers;


public interface EventWrapper {
    public void setEventSource(Object eventSource);

    public void setEventType(Object eventType);

    public void setEventData(Object eventData);

    public Object getEventSource();

    public Object getEventType();

    public Object getEventData();
}
