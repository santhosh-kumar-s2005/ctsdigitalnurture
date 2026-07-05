package com.example.employeemanagementsystem.projection;

public interface EmployeeDepartmentProjection {

    String getName();

    String getEmail();

    DepartmentInfo getDepartment();

    interface DepartmentInfo {
        String getName();
    }
}
