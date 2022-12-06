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
        employees.add(new Employee(1,"Thomas", 20, "Male", 8000));
        employees.add(new Employee(2,"Michael", 21, "Male", 8000));
        employees.add(new Employee(3,"Amy", 22, "Female", 8000));
        employees.add(new Employee(4,"Brian", 20, "Male", 8000));
        employees.add(new Employee(5,"Ken", 21, "Male", 8000));
        employees.add(new Employee(6,"Carrie", 22, "Female", 8000));
        employees.add(new Employee(7,"Peter", 20, "Male", 8000));
        employees.add(new Employee(8,"Avalon", 21, "Male", 8000));

    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee findById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId()==id)
                .findFirst()
                .get();
    }

    public List<Employee> findByGender(String gender) {
        return employees.stream()
                .filter(employee -> employee.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public Employee create(Employee employee) {
        Integer id = generateNextId();
        employee.setId(id);
        employees.add(employee);
        return employee;
    }

    private Integer generateNextId() {
        int nextId = employees.stream()
                .mapToInt(employee -> employee.getId())
                .max()
                .orElse(1);
        return nextId + 1;
    }

    public Employee update(Integer id, Employee employee) {
        Employee existingEmployee = findById(id);
        if(employee.getAge() != null){
            existingEmployee.setAge(employee.getAge());
        }
        if(employee.getSalary() != null) {
            existingEmployee.setSalary(employee.getSalary());
        }
        return existingEmployee;
    }

    public void delete(Integer id) {
        employees = employees
                .stream()
                .filter(employee -> !employee.getId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Employee> findByPage(long page, long pageSize) {
        return employees
                .stream()
                .skip((page-1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }
}

//{
//    "id": 5,
//    "name": "Lily",
//    "age": 20,
//    "gender": "Female",
//    "salary": 8000
//}
