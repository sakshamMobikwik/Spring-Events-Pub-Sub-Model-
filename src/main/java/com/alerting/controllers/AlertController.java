package com.alerting.controllers;

import com.alerting.dto.Object;
import com.alerting.events.GenericEvent;
import com.alerting.events.AlertEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertController {

    @Autowired
    private AlertEventProducer eventProducer;

    @GetMapping("/produce")
    public void produceEvent() {
        Object alertInfoDTO = new Object();
        alertInfoDTO.setLocation("Maharshtra");
        alertInfoDTO.setIp("10:10:10:187");
        alertInfoDTO.setUsername("Saksham");
        GenericEvent alertEvent = new GenericEvent(this,"Produce",alertInfoDTO);
        this.eventProducer.produce(alertEvent);
    }
}
