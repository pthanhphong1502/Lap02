package com.example.lap02_3;

public class EmployeeParttime extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public EmployeeParttime(String id, String name, double hourlyRate, int hoursWorked) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        // Include salary information in the string representation
        return super.toString() + ", Hourly Rate: " + hourlyRate
                + ", Hours Worked: " + hoursWorked + ", Salary: " + calculateSalary();
    }
}
