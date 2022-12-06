package com.afs.employee.demo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    List<Employee> employees;

    public EmployeeRepository(){
        this.employees = new ArrayList<>();
        employees.add(new Employee(1,"Thomas", 20, "Male", 8000));
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
