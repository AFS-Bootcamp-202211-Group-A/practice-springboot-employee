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


    public Employee findById(Integer id){
        return employees.stream().filter(employee -> employee.getId() == id).findFirst().get();
    }

    public List<Employee> findAllByGender(String gender) {
        return employees.stream().filter(employee -> employee.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Employee create(Employee employee) {
        int id = generateNextId();
        employee.setId(id);
        employees.add(employee);
        return employee;

    }

    private Integer generateNextId() {
        int nextId = employees
                .stream()
                .mapToInt(employee -> employee.getId())
                .max()
                .orElse(1);
        return nextId + 1;
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

    public List<Employee> delete(Integer id) {
        return employees
                .stream()
                .filter(employee -> employee.getId() != id)
                .collect(Collectors.toList());
    }

    public List<Employee> getListByPage(Integer page, Integer pageSize) {
        Integer startIndex = (page - 1) * pageSize;
        Integer toIndex = startIndex + pageSize;
        return employees.subList(startIndex, toIndex);
    }
}
