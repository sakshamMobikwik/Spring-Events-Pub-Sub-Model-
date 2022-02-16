package com.example.dao;

import com.example.interfaces.EmployeeDAO;
import com.example.model.EmployeeDTO;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public EmployeeDTO createNewEmployee() {
        EmployeeDTO e = new EmployeeDTO();
        e.setId(1);
        e.setFirstName("Lokesh");
        e.setLastName("Gupta");
        e.setDesignation("SDE3");
        return e;
    }
    public void initBean() {
        System.out.println("Init Bean for : EmployeeDAOImpl");
    }

    public void destroyBean() {
        System.out.println("Init Bean for : EmployeeDAOImpl");
    }
}
