package com.alerting.controllers;

import com.alerting.dto.Object;
import com.alerting.events.AlertEventProducer;
import com.alerting.events.LoginEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertController {

    @Autowired
    private AlertEventProducer eventProducer;

    @GetMapping("/produce")
    public void produceEvent() {
        try {
            Object alertInfoDTO = new Object();
            alertInfoDTO.setLocation("Maharshtra");
            alertInfoDTO.setIp("10:10:10:187");
            alertInfoDTO.setUsername("Saksham");
            LoginEvent alertEvent = new LoginEvent(this,"Produce",alertInfoDTO);
            this.eventProducer.produce(alertEvent);


            alertInfoDTO = new Object();
            alertInfoDTO.setLocation("Gujarat");
            alertInfoDTO.setIp("10:90:10:187");
            alertInfoDTO.setUsername("Jainil");
            LoginEvent alertEvent1 = new LoginEvent(this,"Login",alertInfoDTO);
            this.eventProducer.produce(alertEvent1);

            alertInfoDTO = new Object();
            alertInfoDTO.setLocation("Gujarat");
            alertInfoDTO.setIp("10:90:10:187");
            alertInfoDTO.setUsername("Jainil");
            LoginEvent alertEvent3 = new LoginEvent(this,"Conduct",alertInfoDTO);
            this.eventProducer.produce(alertEvent3);

        }catch (Exception e) {
         e.printStackTrace();
        }

    }
}
