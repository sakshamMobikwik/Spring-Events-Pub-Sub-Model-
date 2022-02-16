package com.example.processors;


import com.example.events.EmployeeEvent;
import com.example.model.EmployeeDTO;
import org.springframework.context.ApplicationEventPublisher;

public class EmployeePublisherProcessor implements Runnable{

    private ApplicationEventPublisher applicationEventPublisher;

    private EmployeeDTO employeeDTO;

    public EmployeePublisherProcessor(EmployeeDTO employeeDTO, ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher=applicationEventPublisher;
        this.employeeDTO = employeeDTO;
    }
    @Override
    public void run() {
        processEmployeeEvent(this.employeeDTO,this.applicationEventPublisher);
    }

    public boolean processEmployeeEvent(EmployeeDTO employeeDTO,ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("Processing Employee Event (Publishing) "+employeeDTO);

        System.out.println("Publishing Employee Add Event");
        System.out.println("********-------*********");
        this.applicationEventPublisher.publishEvent(new EmployeeEvent(this, "ADD", employeeDTO));
        return employeeDTO != null;
    }
}
