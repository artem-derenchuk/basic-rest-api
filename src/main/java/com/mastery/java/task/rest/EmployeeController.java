package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employee")
    public Collection<Employee> employees() {
        return employeeService.findAll();
    }

    @GetMapping(value = "/employee/{employeeId}")
    public ResponseEntity<Employee> findById(@PathVariable Long employeeId) {
        Optional<Employee> optional = employeeService.findById(employeeId);
        return optional.isPresent()
                ? new ResponseEntity<>(optional.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/employee")
    public ResponseEntity<Long> createEmployee(@RequestBody Employee employee) {
        Long employeeId = employeeService.createEmployee(employee);
        return new ResponseEntity<>(employeeId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/employee")
    public ResponseEntity<Long> updateEmployee(@RequestBody Employee employee) {
        Long result = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(value = "/employee/{employeeId}")
    public ResponseEntity<Long> deleteEmployee(@PathVariable Long employeeId) {
        long result = employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
