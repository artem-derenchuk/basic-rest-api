package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Optional<Employee> findById(Long employeeId) {
        return employeeDao.findById(employeeId);
    }

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public Long createEmployee(Employee employee) {
        return employeeDao.createEmployee(employee);
    }

    public Long updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    public Long deleteEmployee(Long employeeId) {
        return employeeDao.delete(employeeId);
    }

}
