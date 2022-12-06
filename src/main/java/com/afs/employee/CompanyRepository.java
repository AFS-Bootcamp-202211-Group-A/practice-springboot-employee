package com.afs.employee;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CompanyRepository {
    private List<Company> companies = new ArrayList<>();


    private List<Employee> employeesList1 = Arrays.asList(new Employee(1, "Lily", 20, "female", 8000),
            new Employee(2, "Lily2", 21, "female", 8100));

    private List<Employee> employeesList2 = Arrays.asList(new Employee(1, "Jenny", 20, "female", 8000),
            new Employee(2, "Jenny2", 21, "female", 8100));

    public CompanyRepository() {
        companies.add(new Company(1, "company1", employeesList1));
        companies.add(new Company(2, "company2", employeesList2));
        companies.add(new Company(3, "company3", employeesList1));
        companies.add(new Company(4, "company4", employeesList2));
        companies.add(new Company(5, "company5", employeesList1));
        companies.add(new Company(6, "company6", employeesList2));
    }

    public List<Company> findAll() {
        return companies;
    }

    public Company findById(Integer id) {
        return companies.stream()
                .filter(company -> company.getId().equals(id))
                .findFirst().get();
    }

    public List<Employee> findAllEmployeeById(Integer id) {
        Company companyById = companies.stream()
                .filter(company -> company.getId().equals(id))
                .findFirst()
                .get();
        return companyById.getEmployees();
    }

    public List<Company> findByPage(Integer page, Integer pageSize) {
        return companies.stream()
                .skip(page-1)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public Company create(Company company) {
        Integer nextId = generateNextId();
        company.setId(nextId);
        companies.add(company);
        return company;
    }

    private Integer generateNextId() {
        int nextId = companies.stream()
                .mapToInt(Company::getId)
                .max()
                .orElse(1);
        return nextId+1;
    }

    public Company update(Integer id, Company company) {
        Company existingCompany = findById(id);
        if (company.getCompanyName() != null){
            existingCompany.setCompanyName(company.getCompanyName());
        }
        return existingCompany;
    }

    public Company delete(Company company) {
        companies.remove(company);
        return company;
    }
}
