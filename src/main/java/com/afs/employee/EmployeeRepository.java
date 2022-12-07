package com.afs.employee;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    List<Employee> employeeList;

    public EmployeeRepository(List<Employee> employeeList) {
        this.employeeList = employeeList;
        this.employeeList.add(new Employee(1, "Lily", 20, "Female", 8000));
        this.employeeList.add(new Employee(2, "Lucy", 21, "Female", 7000));
        this.employeeList.add(new Employee(3, "Leo", 19, "Male", 60100));
        this.employeeList.add(new Employee(4, "Leo1", 129, "Male", 62000));
        this.employeeList.add(new Employee(5, "Leo2", 1329, "Male", 60300));
        this.employeeList.add(new Employee(6, "Leo3", 139, "Male", 60050));
    }

    public List<Employee> getAll() {
        return employeeList;
    }

    public Employee getOneWithID(Integer id) {
        return employeeList.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow(NoEmployeeFoundException::new);
    }

    public List<Employee> getEmployeeByGender(String gender) {
        System.out.println(gender);
        return employeeList.stream().filter(employee -> employee.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Employee create(Employee employee) {
        Integer id = generateNextId();
        employee.setId(id);
        employeeList.add(employee);
        return employee;
    }

    private Integer generateNextId() {
        int nextId = employeeList.stream()
                .mapToInt(Employee::getId)
                .max()
                .orElse(1);
        return nextId + 1;
    }

    public Employee update(Integer id, Employee employee) {
        try {
            Employee selectedEmployee = getOneWithID(id);
            selectedEmployee.setAge(employee.getAge());
            selectedEmployee.setSalary(employee.getSalary());
            return selectedEmployee;
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(Integer id) {
        this.employeeList = employeeList.stream()
                .filter(employee -> !(employee.getId().equals(id)))
                .collect(Collectors.toList());
        System.out.println(employeeList);
    }

    public List<Employee> getEmployeeListWithID(Integer page, Integer pageSize) {
        int initial_index = (page - 1) * pageSize;
        int end_index = initial_index + pageSize;
        return employeeList.subList(initial_index, end_index);
    }
}
