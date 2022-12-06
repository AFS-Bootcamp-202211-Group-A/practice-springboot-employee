package com.afs.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class Company {
    private Integer id;
    private String name;
    private List<Employee> employees;

    public Company(Integer id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
