package com.afs.employee;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    
    @GetMapping
    public List<Employee> getAll() {
        
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id) {

        return employeeRepository.findById(id);
    }

    @GetMapping(params = {"gender"})
    public List<Employee> getAllByGender(@RequestParam String gender){
        return employeeRepository.findAllByGender(gender);
    }

    //POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.create(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        return employeeRepository.update(id, employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Employee> deleteById(@PathVariable Integer id){
        return employeeRepository.delete(id);
    }


    @GetMapping(params = {"page", "pageSize"})
    public List<Employee> getListByPage(@RequestParam Integer page, @RequestParam Integer pageSize){
        return employeeRepository.getListByPage(page, pageSize);
    }
    
}
