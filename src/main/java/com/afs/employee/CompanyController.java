package com.afs.employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<Company> getAll() {
        return companyRepository.getAll();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Integer id) {
        return companyRepository.getCompanyById(id);
    }
//    GET       /companies/1/employees  # obtain list of all employee under a certain specific company
//
//    GET       /companies?page=1&pageSize=5  #Page query, if page equals 1, pageSize equals 5, it will return the data in company list from index 0 to index 4.
//
    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.createCompany(company);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Integer id, @RequestBody Company company) {
        return companyRepository.updateCompany(id, company);
    }

    @DeleteMapping("{id}")
    public Company deleteCompany(@PathVariable Integer id) {
        return companyRepository.deleteCompany(id);
    }

}
