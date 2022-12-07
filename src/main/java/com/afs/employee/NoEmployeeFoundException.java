package com.afs.employee;

public class NoEmployeeFoundException extends RuntimeException {
    public NoEmployeeFoundException() {
        super("No employee found");
    }
}
