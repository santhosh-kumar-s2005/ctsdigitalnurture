package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

    private static ArrayList<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {
        LOGGER.debug("Inside EmployeeDao Constructor.");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
    }

    public List<Employee> getAllEmployees() {
        LOGGER.info("START");
        LOGGER.info("END");
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee updatedEmployee) throws EmployeeNotFoundException {
        LOGGER.info("START");
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId() == updatedEmployee.getId()) {
                EMPLOYEE_LIST.set(i, updatedEmployee);
                LOGGER.debug("Employee updated: {}", updatedEmployee);
                LOGGER.info("END");
                return;
            }
        }
        throw new EmployeeNotFoundException("Employee not found with id: " + updatedEmployee.getId());
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        LOGGER.info("START");
        Employee toRemove = null;
        for (Employee emp : EMPLOYEE_LIST) {
            if (emp.getId() == id) {
                toRemove = emp;
                break;
            }
        }
        if (toRemove == null) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        EMPLOYEE_LIST.remove(toRemove);
        LOGGER.debug("Employee deleted with id: {}", id);
        LOGGER.info("END");
    }
}
