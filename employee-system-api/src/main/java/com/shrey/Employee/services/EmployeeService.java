package com.shrey.Employee.services;

import com.shrey.Employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(long id);


    Employee getEmployeeById(Long id);

    Employee updateEmployee(long id, Employee employee);
}
