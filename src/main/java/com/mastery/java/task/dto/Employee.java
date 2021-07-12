package com.mastery.java.task.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private Integer department_id;
    private String job_title;
    private Gender gender;
    private LocalDate date_of_birth;

    public Employee(Long employeeId, String firstName, String lastName, Integer department_id, String job_title, Gender gender, LocalDate date_of_birth) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department_id = department_id;
        this.job_title = job_title;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
    }

    public Employee() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(department_id, employee.department_id) && Objects.equals(job_title, employee.job_title) && gender == employee.gender && Objects.equals(date_of_birth, employee.date_of_birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, department_id, job_title, gender, date_of_birth);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department_id=" + department_id +
                ", job_title='" + job_title + '\'' +
                ", gender=" + gender +
                ", date_of_birth=" + date_of_birth +
                '}';
    }
}
