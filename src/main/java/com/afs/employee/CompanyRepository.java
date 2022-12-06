package com.afs.employee;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepository {

    private List<Company> companies;

    public CompanyRepository(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        companies = new ArrayList<>();
        companies.add(new Company(1, "spring", employeeRepository.findAll().subList(0,2)));
        companies.add(new Company(2, "summer", employeeRepository.findAll().subList(2,4)));
        companies.add(new Company(3, "autumn", employeeRepository.findAll().subList(4,6)));
        companies.add(new Company(4, "winter", employeeRepository.findAll().subList(6,8)));
    }


    public List<Company> findAll() {
        return companies;
    }
}
