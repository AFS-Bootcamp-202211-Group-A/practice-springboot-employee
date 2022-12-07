package com.afs.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Company {

    private Integer id;
    private String name;
    private final List<Employee> employees;
    public Company(Integer id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public List<Employee> getEmployees() {
        return employees;
    }
}
