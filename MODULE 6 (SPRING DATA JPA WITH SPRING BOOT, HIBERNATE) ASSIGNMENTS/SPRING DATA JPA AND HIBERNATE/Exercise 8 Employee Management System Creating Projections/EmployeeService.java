package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.dto.EmployeeSummaryDTO;
import com.example.employeemanagementsystem.projection.EmployeeDepartmentProjection;
import com.example.employeemanagementsystem.projection.EmployeeNameEmailProjection;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeNameEmailProjection> getNameEmailByDepartment(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    public List<EmployeeDepartmentProjection> getEmployeeWithDepartment(String name) {
        return employeeRepository.findByName(name);
    }

    public List<EmployeeSummaryDTO> getEmployeeSummaries() {
        return employeeRepository.findEmployeeSummaries();
    }
}
