package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeBatchService {

    private static final int BATCH_SIZE = 20;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void batchInsertEmployees(List<Employee> employees) {
        List<Employee> batch = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            batch.add(employees.get(i));
            if (batch.size() == BATCH_SIZE) {
                employeeRepository.saveAll(batch);
                batch.clear();
            }
        }
        if (!batch.isEmpty()) {
            employeeRepository.saveAll(batch);
        }
    }

    @Transactional
    public void batchDeleteByDepartment(Long departmentId) {
        List<Employee> employees = employeeRepository.findByDepartmentId(departmentId);
        employeeRepository.deleteAll(employees);
    }
}
