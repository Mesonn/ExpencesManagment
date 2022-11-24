package com.goundicorp.expenses.utilities;

import com.goundicorp.expenses.domain.Employee;
import com.goundicorp.expenses.domain.EmployeesInMemoryImpl;
import com.goundicorp.expenses.exceptions.InvalidEmployeeIdException;
import com.goundicorp.expenses.exceptions.NameTooShortException;

public class EmployeeUtilities {
    public boolean employeeExists(EmployeesInMemoryImpl employees, Employee employee){
        return employees.findBySurname(employee.getSurName()) != null ;
    }
    public Integer validateEmployeeId(String inputID) throws InvalidEmployeeIdException {
        try{
            Integer id = Integer.valueOf(inputID);
            return id;
        }
            catch (NumberFormatException e){
                throw new InvalidEmployeeIdException();
            }
    }

    public void validateEmployeeName(String firstName, String surName) throws NameTooShortException {
        Integer length = firstName.length() + surName.length();
        if(length < 6){
            throw new NameTooShortException();
        }

    }


}
