package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);

    private static ArrayList<Department> DEPARTMENT_LIST;

    public DepartmentDao() {
        LOGGER.debug("Inside DepartmentDao Constructor.");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        DEPARTMENT_LIST = new ArrayList<>();
        DEPARTMENT_LIST.add(context.getBean("dept1", Department.class));
        DEPARTMENT_LIST.add(context.getBean("dept2", Department.class));
        DEPARTMENT_LIST.add(context.getBean("dept3", Department.class));
        LOGGER.debug("Loaded {} departments from xml.", DEPARTMENT_LIST.size());
    }

    public List<Department> getAllDepartments() {
        LOGGER.info("START");
        LOGGER.debug("Returning {} departments.", DEPARTMENT_LIST.size());
        LOGGER.info("END");
        return DEPARTMENT_LIST;
    }
}
