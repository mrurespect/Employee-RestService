package com.example.employeeapp.dao;

import com.example.employeeapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteByID(int id);


}
