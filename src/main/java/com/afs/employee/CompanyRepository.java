package com.afs.employee;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CompanyRepository {
    private final List<Company> companyList;

    public CompanyRepository(List<Company> companyList) {
        this.companyList = companyList;
        Employee lily = new Employee(1, "Lily", 20, "Female", 8000);
        Employee lucy = new Employee(2, "Lucy", 21, "Female", 7000);
        Employee leo = new Employee(3, "Leo", 19, "Male", 6000);
        companyList.add(new Company(1, "spring", Arrays.asList(lily)));
        companyList.add(new Company(2, "boot", Arrays.asList(lucy, leo)));
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

    private int generateNextId() {
        int nextId = this.companyList.stream()
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

    public List<Employee> getEmployeesInCompanyById(Integer id) {
        Company company = getCompanyById(id);
        return company.getEmployees();
    }
}
