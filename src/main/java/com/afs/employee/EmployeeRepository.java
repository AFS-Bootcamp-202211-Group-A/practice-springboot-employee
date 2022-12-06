package com.afs.employee;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    List<Employee> employees;

    public EmployeeRepository(){
        this.employees = new ArrayList<>();
        employees.add(new Employee(1,"Thomas", 20, "Male", 8000));
        employees.add(new Employee(2,"Michael", 21, "Male", 8000));
        employees.add(new Employee(3,"Amy", 22, "Female", 8000));
    }

    public List<Employee> findAll() {
        return employees;
    }
}

//{
//    "id": 5,
//    "name": "Lily",
//    "age": 20,
//    "gender": "Female",
//    "salary": 8000
//}
