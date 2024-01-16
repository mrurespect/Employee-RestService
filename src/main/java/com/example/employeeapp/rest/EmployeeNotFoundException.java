package com.example.employeeapp.rest;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
