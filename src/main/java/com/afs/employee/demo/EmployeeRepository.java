package com.afs.employee.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    List<Employee> employees;
    public EmployeeRepository(){
        this.employees = new ArrayList<>();
        employees.add(new Employee(1,"Lily",20,"Female",8000));
        employees.add(new Employee(2,"Lily2",20,"Female",8000));
        employees.add(new Employee(3,"Lily3",20,"Female",8000));
        employees.add(new Employee(4,"Lily4",20,"Female",8000));
        employees.add(new Employee(5,"Lily5",20,"Female",8000));
        employees.add(new Employee(6,"Lily6",20,"Female",8000));
        employees.add(new Employee(7,"Lily7",20,"Female",8000));
        employees.add(new Employee(8,"Lily8",20,"Female",8000));
    }

    public List<Employee> findAll(){
        return employees;
    }

    public List<Employee> findEmployeeById(int id) {
        return employees.stream().filter(employee->employee.getId()==id).collect(Collectors.toList());
    }

    public List<Employee> findEmployeeByGender(String gender) {
        return employees.stream().filter(employee-> employee.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Employee createEmployee(Employee employee) {
        employee.setId(generateNewEmployeeId());
        employees.add(employee);
        return employee;
    }

    private Integer generateNewEmployeeId(){
        return employees
                .stream()
                .mapToInt(Employee::getId)
                .max()
                .orElse(1) + 1;
    }

    public Employee updateEmployee(Integer id, Employee employee) {
        Employee existingEmployee = employees.stream().filter(i -> i.getId().equals(id)).findFirst().get();
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setSalary(employee.getSalary());

        return existingEmployee;
    }

    public void deleteEmployee(Integer id) {
        employees.removeIf(i -> i.getId().equals(id));
    }

    public List<Employee> getEmployeeByPage(int page, int pageSize) {
        return employees.subList(pageSize*(page-1), page*pageSize);
    }
}
