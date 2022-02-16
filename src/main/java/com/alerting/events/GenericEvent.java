package com.alerting.events;

import com.alerting.dto.Object;
import com.alerting.wrappers.EventWrapper;
import org.springframework.context.ApplicationEvent;

public class GenericEvent extends ApplicationEvent implements EventWrapper
{
    private static final long serialVersionUID = 1L;

    private java.lang.Object eventSource;

    private String eventType;

    private Object data;

    //Constructor's first parameter must be source
    public GenericEvent(java.lang.Object source, String eventType, Object data)
    {
        //Calling this super class constructor is necessary
        super(source);
        this.setEventSource(source);
        this.setEventType(eventType);
        this.setEventData(data);
        this.eventType = eventType;
        this.eventSource = source;
        this.data = data;
    }

    @Override
    public void setEventSource(java.lang.Object eventSource) {
      this.eventSource = eventSource;
    }

    @Override
    public void setEventType(java.lang.Object eventType) {
      this.eventType = eventType.toString();
    }

    @Override
    public void setEventData(java.lang.Object eventData) {
       this.data = (Object) eventData;
    }

    @Override
    public java.lang.Object getEventSource() {
        return this.eventSource;
    }

    @Override
    public String getEventType() {
        return this.eventType;
    }

    @Override
    public java.lang.Object getEventData() {
        return this.data;
    }

    public Object getData() {return this.data;}
}