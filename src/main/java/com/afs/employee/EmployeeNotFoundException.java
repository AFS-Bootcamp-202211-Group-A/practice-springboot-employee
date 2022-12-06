package com.afs.employee;

import java.util.function.Supplier;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(){
        super("Employee not found");
    }
}
