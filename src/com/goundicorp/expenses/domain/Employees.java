package com.goundicorp.expenses.domain;

import com.goundicorp.expenses.domain.Employee;
import com.goundicorp.expenses.exceptions.EmployeeNotFoundException;

import java.util.*;

public class Employees {
    private Map<Integer, Employee> employees = new HashMap<>();


    public void addEmployee(Employee employee){
      employees.put(employee.getId(), employee);
    }
    public void printEmployees(){
        List<Employee> employeeList = new ArrayList<>(employees.values());
        Collections.sort(employeeList);
        for(Employee e : employeeList) {
            System.out.println(e);
            for(ExpenseClaim claim : e.getClaims().values()){
                System.out.println(claim);
                claim.printExpenseItems();
                System.out.println("Total value of claim" + claim.getTotalAmount());
            }
        }
    }

    public Employee findBySurname(String surname){
        for(Employee e : employees.values()){
            if ( e.getSurName().equals(surname)){
                return e;
            }

        }
        return null ;
    }


    public Employee findByID(int id){
        return employees.get(id);

        }


    public boolean employeeExists(int id) {
        return employees.containsKey(id);

    }


    public void addExpenseClaim(ExpenseClaim claim)throws EmployeeNotFoundException{
        int employeeId = claim.getEmployeeId();
        if(!employeeExists(employeeId)){
            throw new EmployeeNotFoundException();
        }
        for (Employee e: employees.values()) {
            if(e.getId()==employeeId) {
                e.getClaims().put(claim.getId(), claim);

            }
        }
    }

}
