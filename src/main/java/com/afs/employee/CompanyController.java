package com.afs.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //    GET       /companies/1  #obtain a certain specific company
    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Integer id) {
        return companyRepository.getCompanyById(id);
    }

//    GET       /companies/1/employees  # obtain list of all employee under a certain specific company
//
//    GET       /companies?page=1&pageSize=5  #Page query, if page equals 1, pageSize equals 5, it will return the data in company list from index 0 to index 4.
//
//    POST      /companies    #add a company
//
//    PUT       /companies/1  #update a company name
//
//    DELETE    /companies/1  # delete a company


}
