package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByNameContainingIgnoreCase(String keyword, Pageable pageable);

    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE e.department.id = :deptId")
    Page<Employee> findByDepartment(@Param("deptId") Long deptId, Pageable pageable);
}
