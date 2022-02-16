package com.example.service;

import com.example.events.EmployeeEvent;
import com.example.processors.EmployeeSubscriberProcessor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Event Subscriber Class
 */

@Component
public class EmployeeSubscriber implements ApplicationListener<EmployeeEvent>
{
    private int THREAD_COUNT = 10;
    final ExecutorService consumers = Executors.newFixedThreadPool(THREAD_COUNT);

    @Override
    public void onApplicationEvent(EmployeeEvent event)
    {
        EmployeeEvent employeeEvent = (EmployeeEvent) event;
        for (int i=0;i<THREAD_COUNT;i++) {
            consumers.submit(new EmployeeSubscriberProcessor(employeeEvent.getEmployee()));
        }
        consumers.shutdown();
//
//        System.out.println("Subscribing Employee Add Event");
//        System.out.println("********-------*********");
//        System.out.println("Employee " + employeeEvent.getEventType()
//                + " with details : " + employeeEvent.getEmployee());

        // Do more processing as per application logic
    }
}