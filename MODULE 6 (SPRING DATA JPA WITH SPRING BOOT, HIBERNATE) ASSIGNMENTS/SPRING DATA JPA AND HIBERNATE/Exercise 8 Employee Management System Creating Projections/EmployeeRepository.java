package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.dto.EmployeeSummaryDTO;
import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.projection.EmployeeDepartmentProjection;
import com.example.employeemanagementsystem.projection.EmployeeNameEmailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<EmployeeNameEmailProjection> findByDepartmentId(Long departmentId);

    List<EmployeeDepartmentProjection> findByName(String name);

    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeSummaryDTO(e.name, e.department.name) FROM Employee e")
    List<EmployeeSummaryDTO> findEmployeeSummaries();
}
