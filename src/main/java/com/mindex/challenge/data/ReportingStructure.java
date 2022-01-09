package com.mindex.challenge.data;

/*
 * This is an implementation of the ReportingStructure class which contains two fields- number Of Reports for an
 * employee and the object corresponding to that employee.
 */
public class ReportingStructure {
    private int numberOfReports;
    private Employee employee;

    public ReportingStructure(int numberOfReports, Employee employee) {
        this.numberOfReports = numberOfReports;
        this.employee = employee;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "ReportingStructure{" +
                "numberOfReports=" + numberOfReports +
                ", employee=" + employee +
                '}';
    }
}
