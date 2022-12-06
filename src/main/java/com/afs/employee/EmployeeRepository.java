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
        this.employeeList.add(new Employee(3, "Leo", 19, "Male", 6000));
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

    public Employee create(Employee employee){
        Integer id = generateNextId();
        employee.setId(id);
        employeeList.add(employee);
        return employee;
    }

    private Integer generateNextId(){
        int nextId = employeeList.stream()
                .mapToInt(employee->employee.getId())
                .max()
                .orElse(1);
        return nextId+1;
    }
}
