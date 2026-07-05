package com.cognizant.ormlearn.dao;

import com.cognizant.ormlearn.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class EmployeeDao {

    private static SessionFactory factory;

    static {
        factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
    }

    public Integer addEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try {
            tx = session.beginTransaction();
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    public List<Employee> listEmployees() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Employee> employees = null;
        try {
            tx = session.beginTransaction();
            employees = session.createQuery("FROM Employee", Employee.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employees;
    }

    public Employee getEmployee(int id) {
        Session session = factory.openSession();
        Transaction tx = null;
        Employee employee = null;
        try {
            tx = session.beginTransaction();
            employee = session.get(Employee.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employee;
    }
}
