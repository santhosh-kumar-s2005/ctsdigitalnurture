package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    Optional<Employee> findByEmail(String email);

    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findByNameContainingIgnoreCase(String keyword);

    List<Employee> findByDepartmentName(String departmentName);

    @Query("SELECT e FROM Employee e WHERE e.department.id = :deptId AND e.name LIKE %:name%")
    List<Employee> findByDepartmentAndName(@Param("deptId") Long deptId, @Param("name") String name);

    @Query(value = "SELECT * FROM employee WHERE email = :email", nativeQuery = true)
    Optional<Employee> findByEmailNative(@Param("email") String email);
}
