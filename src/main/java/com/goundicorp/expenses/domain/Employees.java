package com.goundicorp.expenses.domain;

import com.goundicorp.expenses.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface Employees {
    void addEmployee(Employee employee);

    List<Employee> getEmployeeList();

    void printEmployees();

    Employee findBySurname(String surname);

    Employee findByID(int id);

    boolean employeeExists(int id);

    void addExpenseClaim(ExpenseClaim claim) throws EmployeeNotFoundException;
}
