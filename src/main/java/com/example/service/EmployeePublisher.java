package com.example.service;

import com.example.events.EmployeeEvent;
import com.example.interfaces.EmployeeDAO;
import com.example.interfaces.EmployeeManager;
import com.example.model.EmployeeDTO;
import com.example.processors.EmployeePublisherProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Event Publisher Class
 */
@Service("employeePublisher")
public class EmployeePublisher implements EmployeeManager, ApplicationEventPublisherAware
{
    @Autowired
    private EmployeeDAO dao;

    private ApplicationEventPublisher publisher;

    private int THREAD_COUNT = 10;
    final ExecutorService publishers = Executors.newFixedThreadPool(THREAD_COUNT);

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public EmployeeDTO createNewEmployee()
    {

        EmployeeDTO employee =  dao.createNewEmployee();

        //publishing the event here
        System.out.println("Publishing Employee Add Event");
        System.out.println("********-------*********");
        for(int i=0;i<THREAD_COUNT;i++) {
            publishers.submit(new EmployeePublisherProcessor(employee,publisher));
        }
        publishers.shutdown();
        return employee;
    }
}
