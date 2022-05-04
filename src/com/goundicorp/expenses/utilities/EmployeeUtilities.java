package com.goundicorp.expenses.utilities;

import com.goundicorp.expenses.domain.Employee;
import com.goundicorp.expenses.domain.Employees;

public class EmployeeUtilities {
    public boolean employeeExists(Employees employees, Employee employee){
        return employees.findBySurname(employee.getSurName()) != null ;
    }
}
