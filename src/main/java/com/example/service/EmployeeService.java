package com.example.service;

import com.example.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> fetchEmployeeList();

    Employee updateEmployee(Employee employee, Long id);

    void deleteEmployeeById(Long id);
}
