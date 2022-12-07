package com.afs.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    List<Company> getAll() {
        return companyRepository.getAll();
    }
    @GetMapping("/{id}")
    Company getCompanyWithID(@PathVariable Integer id) {
        return companyRepository.getCompanyWithID(id);
    }

    @GetMapping("/{id}/employees")
    List<Employee> getEmployeeListByCompanyWithID(@PathVariable Integer id) {
        return companyRepository.getEmployeeListByCompanyWithID(id);
    }

    @GetMapping(params = {"page", "pageSize"})
    public List<Company> getCompanyListWithPageQuery(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return companyRepository.getCompanyListWithPageQuery(page, pageSize);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestBody Company company) {
        return companyRepository.create(company);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Integer id, @RequestBody Company company) {
        return companyRepository.update(id, company);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompanyById(@PathVariable Integer id) {
        companyRepository.delete(id);
    }

}
