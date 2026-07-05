package com.cognizant.ormlearn;

import com.cognizant.ormlearn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        testGetAverageSalary();
        testGetAverageSalaryByDepartment();
    }

    private static void testGetAverageSalary() {
        LOGGER.info("Start");
        double avg = employeeService.getAverageSalary();
        LOGGER.debug("Average Salary (all): {}", avg);
        LOGGER.info("End");
    }

    private static void testGetAverageSalaryByDepartment() {
        LOGGER.info("Start");
        double avg = employeeService.getAverageSalaryByDepartment(1);
        LOGGER.debug("Average Salary (dept 1): {}", avg);
        LOGGER.info("End");
    }
}
