package com.goundicorp.expenses.domain;

import com.goundicorp.expenses.domain.Employee;

public class Employees {
    private Employee[] employees;

    public Employees(int numberOfEmployees){
        employees = new Employee[numberOfEmployees];

    }
    public void addEmployee(Employee employee){
        int firstEmptyPosition = -1 ;
        for (int i = 0; i < employees.length; i++){
            if(firstEmptyPosition == -1 && employees[i] == null){
                firstEmptyPosition = i;
            }
        }
        if(firstEmptyPosition == -1){
            System.out.println("Array is full");
        }
        else{
            employees[firstEmptyPosition] = employee;
        }

    }
    public void printEmployees(){
        for(Employee e : employees){
            if (e != null)
                System.out.println(e.getMailingName());
        }
    }
    public Employee findBySurname(String surname){
        for(Employee e : employees){
            if ( e!= null && e.getSurName().equals(surname)){
                return e;
            }

        }
        return null ;
    }
}
