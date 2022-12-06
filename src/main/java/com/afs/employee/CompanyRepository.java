package com.afs.employee;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CompanyRepository {
    List<Company> companyList;

    public CompanyRepository(List<Company> companyList) {
        this.companyList = companyList;
        companyList.add(new Company(1, "spring"));
        companyList.add(new Company(2, "boot"));
    }

    public List<Company> getAll() {
        return this.companyList;
    }

    public Company getCompanyById(Integer id) {
        return this.companyList.stream()
                .filter(company -> company.getId().equals(id))
                .findFirst()
                .orElseThrow(NoCompanyFoundException::new);
    }

    public Company createCompany(Company company) {
        Integer id = generateNextId();
        company.setId(id);
        this.companyList.add(company);
        return company;
    }

    private Integer generateNextId() {
        Integer nextId = this.companyList.stream()
                .mapToInt(Company::getId)
                .max()
                .orElse(1);
        return nextId + 1;
    }

    public Company updateCompany(Integer id, Company company) {
        Company existingCompany = getCompanyById(id);
        if (existingCompany.getName() != null) {
            existingCompany.setName(company.getName());
        }
        return existingCompany;
    }

    public Company deleteCompany(Integer id) {
        Company existingCompany = getCompanyById(id);
        this.companyList.remove(existingCompany);
        return existingCompany;
    }

    public List<Company> getCompanyByPage(Integer page, Integer pageSize) {
        return companyList.stream().limit(page *pageSize).collect(Collectors.toList());
    }
}
