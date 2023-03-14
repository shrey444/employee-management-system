package com.shrey.Employee.controller;

import com.shrey.Employee.services.EmployeeService;
import lombok.NoArgsConstructor;
import org.hibernate.cfg.annotations.reflection.internal.XMLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shrey.Employee.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
/*@RestController annotation tells us about the class being a
RESTful class*/
@RequestMapping("/api/v1/")
/*@RequestMapping is used to map web requests onto specific
handler classes or methods */
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    /*final keyword here indicates that the value cannot be
    changed for the object created*/
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    /*Here we have created a constructor for the EmployeeController
    so that whenever the object for EmployeeService is created, it
    will automatically be injected */

    @PostMapping("/employees")
    /*@PostMapping is used to handle POST type of request method i.e.,
     it is used to kinda give input */
    public Employee createEmployee(@RequestBody Employee employee){
        /*The body of the request is passed through an
        HttpMessageConverter to resolve the method argument depending
        on the content type of the request. */
        return employeeService.createEmployee(employee);

    }

    @GetMapping("/employees")
        public List<Employee> getAllEmployees(){
            return employeeService.getAllEmployees();
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable long id){
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = null;
        employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,
                                                   @RequestBody Employee employee){
        employee=employeeService.updateEmployee(id,employee);
        return ResponseEntity.ok(employee);
    }
}
