package com.week3.empmgmtsystem.controller;

import com.week3.empmgmtsystem.entity.Employee;
import com.week3.empmgmtsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.week3.empmgmtsystem.dto.EmployeeDTO;
import com.week3.empmgmtsystem.projection.EmployeeProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @GetMapping("/paginated")
    public Page<Employee> getEmployeesPaginated(
            @RequestParam int page, 
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findAll(pageable);
    }
    
    @GetMapping("/sorted")
    public List<Employee> getEmployeesSorted(@RequestParam String sortBy) {
        return employeeRepository.findAll(Sort.by(sortBy));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(employee -> ResponseEntity.ok(employee))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(employeeDetails.getName());
                    employee.setEmail(employeeDetails.getEmail());
                    employee.setDepartment(employeeDetails.getDepartment());
                    return ResponseEntity.ok(employeeRepository.save(employee));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employeeRepository.delete(employee);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/projections")
    public List<EmployeeProjection> getEmployeeProjections() {
        return employeeRepository.findAllEmployeeProjections();
    }

    @GetMapping("/dtos")
    public List<EmployeeDTO> getEmployeeDTOs() {
        return employeeRepository.findAllEmployeeDTOs();
    }
    
}