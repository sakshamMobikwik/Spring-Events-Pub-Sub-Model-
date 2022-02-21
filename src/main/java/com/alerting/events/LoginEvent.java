package com.alerting.events;

import com.alerting.controllers.AlertController;
import com.alerting.dto.Object;
import lombok.Getter;

@Getter
public class LoginEvent extends GenericEvent{
    public LoginEvent(AlertController source, String eventType, Object data) {
        super(source, eventType, data);
    }
}
