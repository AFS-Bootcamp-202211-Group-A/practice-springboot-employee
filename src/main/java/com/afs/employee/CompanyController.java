package com.afs.employee;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/companies")
public class CompanyController {
    CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Integer id) {
        return companyRepository.findById(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployeesByCompanyId(@PathVariable Integer id) {
        return companyRepository.findAllEmployeeById(id);
    }

    @GetMapping(params = {"page", "pageSize"})
    public List<Company> getCompanyDataByPage(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return companyRepository.findByPage(page, pageSize);
    }
}
