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

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesInCompanyById(@PathVariable Integer id) {
        return companyRepository.getEmployeesInCompanyById(id);
    }

    @GetMapping(params = {"page", "pageSize"})
    public List<Company> getCompanyByPage(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return companyRepository.getCompanyByPage(page, pageSize);
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.createCompany(company);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Integer id, @RequestBody Company company) {
        return companyRepository.updateCompany(id, company);
    }

    @DeleteMapping("{id}")
    public void deleteCompany(@PathVariable Integer id) {
        companyRepository.deleteCompany(id);
    }

}
