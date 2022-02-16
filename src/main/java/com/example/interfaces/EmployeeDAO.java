package com.example.interfaces;

import com.example.model.EmployeeDTO;
import org.springframework.stereotype.Repository;

public interface EmployeeDAO
{
    public EmployeeDTO createNewEmployee();
}