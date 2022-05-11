package com.goundicorp.expenses.domain;

import com.goundicorp.expenses.domain.Employee;
import com.goundicorp.expenses.exceptions.EmployeeNotFoundException;

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
                System.out.println(e);
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
    public boolean employeeExists(int id){
        for(Employee e : employees) {
            if (e != null && e.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public void addExpenseClaim(ExpenseClaim claim)throws EmployeeNotFoundException{
        int employeeId = claim.getEmployeeId();
        if(!employeeExists(employeeId)){
            throw new EmployeeNotFoundException();
        }
        for (Employee e: employees) {
            if(e != null && e.getId()==employeeId){
                int firstEmptyPosition = -1;
                for (int i= 0; i < e.getClaims().length; i++){
                    if(firstEmptyPosition == -1 && e.getClaims()[i] == null){
                        firstEmptyPosition = i;
                    }
                }
                e.getClaims()[firstEmptyPosition] = claim;
            }

        }
    }

}
