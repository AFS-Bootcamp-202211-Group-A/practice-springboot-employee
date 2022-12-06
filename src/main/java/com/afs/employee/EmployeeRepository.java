package com.afs.employee;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    List<Employee> employees;

    public EmployeeRepository(){
        this.employees = new ArrayList<>();
        employees.add(new Employee(1, "Lily", 20, "Female", 8000));
        employees.add(new Employee(2, "Lily2", 21, "Female", 8100));
        employees.add(new Employee(3, "Dummy", 22, "Male", 812300));
    }

    public List<Employee> findAll() {
        return employees;
    }


    public Employee findById(int id){
        return employees.stream().filter(employee -> employee.getId() == id).findFirst().get();
    }

    public List<Employee> findAllByGender(String gender) {
        return employees.stream().filter(employee -> employee.getGender().equals(gender)).collect(Collectors.toList());
    }
}
