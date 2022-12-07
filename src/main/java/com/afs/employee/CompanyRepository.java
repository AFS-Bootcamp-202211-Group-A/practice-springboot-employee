package com.afs.employee;

import com.afs.employee.Company;
import com.afs.employee.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CompanyRepository {
    List<Company> companyList;

    public CompanyRepository(List<Company> companyList) {
        this.companyList = companyList;

        List<Employee> employeeList1 = new ArrayList<>();
        List<Employee> employeeList2 = new ArrayList<>();
        employeeList1.add(new Employee(1, "Lily", 20, "Female", 8000));
        employeeList2.add(new Employee(2, "Lucy", 21, "Female", 7000));
        employeeList1.add(new Employee(3, "Leo", 19, "Male", 60100));
        employeeList2.add(new Employee(4, "Leo1", 129, "Male", 62000));
        employeeList1.add(new Employee(5, "Leo2", 1329, "Male", 60300));
        employeeList2.add(new Employee(6, "Leo3", 139, "Male", 60050));

        this.companyList.add(new Company(1, "Google", employeeList1));
        this.companyList.add(new Company(2, "Amazon", employeeList2));

    }

    public List<Company> getAll() {
        return companyList;
    }

    public Company getCompanyWithID(Integer id) {
        return companyList.stream()
                .filter(company -> company.getId().equals(id))
                .findFirst()
                .get();
    }

    public List<Employee> getEmployeeListByCompanyWithID(Integer id) {
        return getCompanyWithID(id).getEmployeeList();
    }

    public List<Company> getCompanyListWithPageQuery(Integer page, Integer pageSize) {
        int initial_index = (page - 1) * pageSize;
        int end_index = initial_index + pageSize;
        return companyList.subList(initial_index, end_index);
    }

    private Integer generateNextId() {
        int nextId = companyList.stream()
                .mapToInt(Company::getId)
                .max()
                .orElse(1);
        return nextId + 1;
    }
    public Company create(Company company) {
        Integer id = generateNextId();
        company.setId(id);
        companyList.add(company);
        return company;
    }

    public Company update(Integer id, Company company) {
        Company selectedCompany= getCompanyWithID(id);
        selectedCompany.setName(company.getName());
        return selectedCompany;
    }

    public void delete(Integer id) {
        this.companyList = companyList.stream()
                .filter(employee -> !(employee.getId().equals(id)))
                .collect(Collectors.toList());
    }
}
