package com.shrey.Employee.services;

import com.shrey.Employee.entities.EmployeeEntity;
import com.shrey.Employee.model.Employee;
import com.shrey.Employee.repositoreis.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.shrey.Employee.controller.EmployeeController;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    /*We create an object of class EmployeeRepository in
      EmployeeServiceImpl so as to access the data from
      the repository */
    @Override
    public Employee createEmployee(Employee employee) {
        /*We create a method createEmployee which has the object
          of class Employee in it */
        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employee, employeeEntity);
        /*Here we copy the properties or values from the employee
        object from class Employee and then paste it into the
        object of EmployeeEntity class, i.e., employeeEntity
         */
        employeeRepository.save(employeeEntity);
        /*We then save the values */
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities
                /*Here we are getting the list of EmployeeEntity
                  from the Repository.*/
                = employeeRepository.findAll();

        List<Employee> employees
                /*this here is the employee defined in the  UI part
                  */
                = employeeEntities.stream()
                /*then we look through the employeeEntities and stream
                  the data into the employee from UI  */
                .map(emp -> new Employee(emp.getId(),
                 /*Then we have created an employee object of Employee
                   UI class where we have get() the data.  */
                 emp.getFirst_name(), emp.getLast_name(),
                 emp.getEmailId())).collect(Collectors.toList());

        return null;
    }

    @Override
    public boolean deleteEmployee(long id) {
        EmployeeEntity employee
                = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        EmployeeEntity employeeEntity
                = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        EmployeeEntity employeeEntity
                = employeeRepository.findById(id).get();
        employee.setEmailId(employee.getEmailId());
        employee.setFirst_name(employee.getFirst_name());
        employee.setLast_name(employee.getLast_name());

        employeeRepository.save(employeeEntity);
        System.out.println(employee);
        return employee;
    }
}
