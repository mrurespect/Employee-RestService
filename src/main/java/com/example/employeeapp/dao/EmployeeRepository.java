package com.example.employeeapp.dao;

import com.example.employeeapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
