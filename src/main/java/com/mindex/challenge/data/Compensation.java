package com.mindex.challenge.data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 This is an implementation of the Compensation class which contains 3 fields- employee corresponding to a particular
 employee, the salary for that employee and the effectiveDate for that employee.
 */
public class Compensation {
    private Employee employee;
    private double salary;
    private LocalDate effectiveDate;

    public Compensation(){ }

    public Compensation(Employee employee, double salary, LocalDate effectiveDate) {
        this.employee = employee;
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public String toString() {
        return "Compensation{" +
                "employee=" + employee +
                ", salary=" + salary +
                ", effectiveDate=" + effectiveDate +
                '}';
    }
}
