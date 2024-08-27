package com.week3.empmgmtsystem.repository;

import com.week3.empmgmtsystem.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.week3.empmgmtsystem.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.week3.empmgmtsystem.dto.EmployeeDTO;


import java.util.Optional;
import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
	
    // Use the named query to find an employee by email
    Optional<Employee> findByEmail(@Param("email") String email);
    
    // Find employees by name with pagination
    Page<Employee> findByName(String name, Pageable pageable);

    // Find all employees with sorting
    List<Employee> findAll(Sort sort);
    
    @Query("SELECT e.id as id, e.name as name, e.email as email, d.name as departmentName FROM Employee e JOIN e.department d")
    List<EmployeeProjection> findAllEmployeeProjections();
    
    @Query("SELECT new com.example.EmployeeManagementSystem.dto.EmployeeDTO(e.id, e.name, e.email, d.name) FROM Employee e JOIN e.department d")
    List<EmployeeDTO> findAllEmployeeDTOs();


}
