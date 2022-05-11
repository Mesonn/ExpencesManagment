package com.goundicorp.expenses;

import com.goundicorp.expenses.domain.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setTitle("Mr");
        employee1.setFirstName("Dali");
        employee1.setSurName("Goundi");
        Employees employees = new Employees(15);
        Employee foundemployee = employees.findBySurname("Brown");

        System.out.println(employee1.getMailingName());
        System.out.println(employee1.getMailingName(true));
        System.out.println(employee1.getMailingName(false ));

        Employee employee2 = new Employee(2,"Manager");
        employee2.setTitle("Dr");
        employee2.setFirstName("Denis");
        employee2.setSurName("Yellow");

        employees.addEmployee(employee1);
        employees.addEmployee(employee2);
        employees.addEmployee(new Employee(3, "Mrs", "Susan", "Brown","Director", Department.MARKETING));

        ExpenseClaim expenseClaim = new ExpenseClaim(24,444, LocalDate.now(),300.0);
        System.out.println(expenseClaim.getEmployeeId());
        expenseClaim.setPaid(true);
        System.out.println(expenseClaim.isPaid());
        expenseClaim.setApproved(true);
        expenseClaim.setPaid(true);
        System.out.println(expenseClaim.isPaid());
        employees.printEmployees();
        ExpenseItem expenseItem = new ExpenseItem(24,588, ExpenseType.ACCOMODATION,"Hotel Duisburg", 500.0);

        System.out.println(employee1.toString());
    }
}
