package com.afs.employee.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Employee> getEmployeeById(@PathVariable int id){
        return employeeRepository.findEmployeeById(id);
    }
//    @GetMapping(params = {""})

    @GetMapping(params = {"gender"})
    public List<Employee> getEmployeeByGender(@RequestParam String gender){
        return employeeRepository.findEmployeeByGender(gender);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.createEmployee(employee);
    }

}
