package com.example.processors;

import com.example.model.EmployeeDTO;

public class EmployeeSubscriberProcessor implements Runnable{

    private EmployeeDTO employeeDTO;
    public EmployeeSubscriberProcessor(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }
    @Override
    public void run() {
      processEmployeeEvent(this.employeeDTO);
    }

    public boolean processEmployeeEvent(EmployeeDTO employeeDTO) {
        System.out.println("Processing Employee Event (Consuming) "+employeeDTO);

        System.out.println("Subscribing Employee Add Event");
        System.out.println("********-------*********");
        return employeeDTO != null;
    }
}
