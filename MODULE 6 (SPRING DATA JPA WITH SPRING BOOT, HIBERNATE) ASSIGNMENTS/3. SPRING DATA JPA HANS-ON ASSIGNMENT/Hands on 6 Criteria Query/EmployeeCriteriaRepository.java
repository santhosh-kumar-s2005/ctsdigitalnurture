package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> findByFilters(Boolean permanent, Double minSalary, Integer departmentId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);

        List<Predicate> predicates = new ArrayList<>();

        if (permanent != null) {
            predicates.add(cb.equal(root.get("permanent"), permanent));
        }

        if (minSalary != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("salary"), minSalary));
        }

        if (departmentId != null) {
            predicates.add(cb.equal(root.get("department").get("id"), departmentId));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Employee> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    public List<Employee> findAllByCriteria() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.select(root);
        TypedQuery<Employee> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    public List<Employee> findByNameContaining(String keyword) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.where(cb.like(root.get("name"), "%" + keyword + "%"));
        return entityManager.createQuery(cq).getResultList();
    }
}
