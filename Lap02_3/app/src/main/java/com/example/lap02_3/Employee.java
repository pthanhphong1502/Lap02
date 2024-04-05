package com.example.lap02_3;

public abstract class Employee {
    protected String id;
    protected String name;
    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name;
    }
}
