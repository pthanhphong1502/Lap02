package com.example.lap02_6;

public class Employee {
    private String id;
    private String fullName;
    private boolean isManager;

    public Employee(String fullName, boolean isManager, String id) {
        this.fullName = fullName;
        this.isManager = isManager;
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isManager() {
        return isManager;
    }

    public String getID() {
        return id;
    }
}
