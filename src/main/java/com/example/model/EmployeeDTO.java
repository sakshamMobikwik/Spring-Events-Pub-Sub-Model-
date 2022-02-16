package com.example.model;

import lombok.Data;

@Data
public class EmployeeDTO
{
    private Integer id;
    private String firstName;
    private String lastName;
    private String designation;

    public EmployeeDTO(String designation)
    {
        this.id = -1;
        this.firstName = "dummy";
        this.lastName = "dummy";
        this.designation = designation;
    }

    public EmployeeDTO() {
        // TODO Auto-generated constructor stub
    }

    //Setters and Getters

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", type=" + designation + "]";
    }
}