package com.example.lap02_3;

public class EmployeeFullTime extends Employee {
    private double monthlySalary;

    public EmployeeFullTime(String id, String name, double salary) {
        super(id, name);
        this.monthlySalary = salary;
    }
    @Override
    public String toString() {
        // Assuming you want to include the monthlySalary in the string representation
        return super.toString() + ", Monthly Salary: " + monthlySalary;
    }
}
