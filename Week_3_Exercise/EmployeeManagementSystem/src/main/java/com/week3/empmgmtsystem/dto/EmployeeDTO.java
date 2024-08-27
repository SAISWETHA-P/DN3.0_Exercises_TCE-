package com.week3.empmgmtsystem.dto;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String departmentName;

    public EmployeeDTO(Long id, String name, String email, String departmentName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
    }


}
