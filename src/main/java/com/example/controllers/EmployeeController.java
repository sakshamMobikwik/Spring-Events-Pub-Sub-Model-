package com.example.controllers;

import com.example.interfaces.EmployeeManager;
import com.example.model.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
    @Autowired
    EmployeeManager manager;

    @GetMapping("/create")
    public EmployeeDTO createNewEmployee()
    {
        return manager.createNewEmployee();
    }
}