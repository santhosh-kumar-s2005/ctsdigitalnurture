package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeCriteriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeCriteriaService criteriaService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        criteriaService = context.getBean(EmployeeCriteriaService.class);
        testFindAllByCriteria();
        testFindByFilters();
        testFindByName();
    }

    private static void testFindAllByCriteria() {
        LOGGER.info("Start - find all using Criteria");
        List<Employee> employees = criteriaService.findAll();
        employees.forEach(e -> LOGGER.debug("{}", e));
        LOGGER.info("End");
    }

    private static void testFindByFilters() {
        LOGGER.info("Start - find by filters: permanent=true, minSalary=50000, dept=1");
        List<Employee> employees = criteriaService.findByFilters(true, 50000.0, 1);
        employees.forEach(e -> LOGGER.debug("{}", e));
        LOGGER.info("End");
    }

    private static void testFindByName() {
        LOGGER.info("Start - find by name containing 'John'");
        List<Employee> employees = criteriaService.findByNameContaining("John");
        employees.forEach(e -> LOGGER.debug("{}", e));
        LOGGER.info("End");
    }
}
