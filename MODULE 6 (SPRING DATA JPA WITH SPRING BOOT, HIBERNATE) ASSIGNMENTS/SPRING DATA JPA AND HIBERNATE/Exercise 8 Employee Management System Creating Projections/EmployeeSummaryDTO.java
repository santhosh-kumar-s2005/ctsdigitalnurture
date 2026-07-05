package com.example.employeemanagementsystem.dto;

public class EmployeeSummaryDTO {

    private String name;
    private String departmentName;

    public EmployeeSummaryDTO(String name, String departmentName) {
        this.name = name;
        this.departmentName = departmentName;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
}
