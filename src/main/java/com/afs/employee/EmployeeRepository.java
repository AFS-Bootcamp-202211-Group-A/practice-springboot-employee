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
        employees.add(new Employee(1, "Lily", 20, "female", 8000));
        employees.add(new Employee(2, "Lily2", 21, "female", 8100));
        employees.add(new Employee(3, "Dummy3", 22, "male", 812300));
        employees.add(new Employee(4, "Lily4", 20, "female", 48000));
        employees.add(new Employee(5, "Lily5", 21, "female", 58100));
        employees.add(new Employee(6, "Dummy6", 22, "male", 68100));
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


    public Employee create(Employee employee) {
        Integer nextId = generateNextId();
        employee.setId(nextId);
        employees.add(employee);
        return employee;
    }

    private Integer generateNextId(){
        int nextId = employees.stream()
                .mapToInt(Employee::getId)
                .max()
                .orElse(1);
        return nextId+1;
    }

    public Employee update(Integer id, Employee employee){
        Employee existingEmployee = findById(id);
        if (employee.getAge() != null){
            existingEmployee.setAge(employee.getAge());
        }
        if(employee.getSalary() != null){
            existingEmployee.setSalary(employee.getSalary());
        }
        return existingEmployee;
    }

    public Employee delete(Employee employee) {
        employees.remove(employee);
        return employee;
    }

    public List<Employee> findByPage(Integer page, Integer pageSize) {
        return employees.stream()
                .skip(page-1)
                .limit(pageSize)
                .collect(Collectors.toList());
    }
}
