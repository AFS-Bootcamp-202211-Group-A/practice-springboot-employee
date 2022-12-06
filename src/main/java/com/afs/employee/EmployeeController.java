package com.afs.employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private  EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }
    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id){
        return null;
    }
    @GetMapping(params = {"?gender={gender}"})
    public Employee getByGender(@RequestParam String gender){
        return null;
    }
}
