package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeCriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeCriteriaService {

    @Autowired
    private EmployeeCriteriaRepository criteriaRepository;

    @Transactional
    public List<Employee> findByFilters(Boolean permanent, Double minSalary, Integer departmentId) {
        return criteriaRepository.findByFilters(permanent, minSalary, departmentId);
    }

    @Transactional
    public List<Employee> findAll() {
        return criteriaRepository.findAllByCriteria();
    }

    @Transactional
    public List<Employee> findByNameContaining(String keyword) {
        return criteriaRepository.findByNameContaining(keyword);
    }
}
