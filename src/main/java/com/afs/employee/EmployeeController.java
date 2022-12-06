package com.afs.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        return employeeRepository.findById(id);
    }
    @GetMapping(params = {"gender"})
    public List<Employee> getByGender(@RequestParam String gender){
        return employeeRepository.findByGender(gender);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.create(employee);
    }
    @PutMapping("/{id}")
    public Employee updateEmployee (@PathVariable int id, @RequestBody Employee employee){
        return employeeRepository.update(id, employee);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee (@PathVariable int id){
        employeeRepository.delete(id);
    }
}
