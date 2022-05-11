package com.goundicorp.expenses;

import com.goundicorp.expenses.domain.Employee;
import com.goundicorp.expenses.domain.Employees;
import com.goundicorp.expenses.domain.ExpenseClaim;
import com.goundicorp.expenses.exceptions.EmployeeNotFoundException;
import com.goundicorp.expenses.ui.UIFunctions;

import java.util.Scanner;

public class ExpenseManagementSystem {
    public static void main(String[] args) {
        Employees employees = new Employees(10);
        Scanner scanner = new Scanner(System.in);
        UIFunctions uiFunctions = new UIFunctions();
        boolean readyToExit = false;

        while (!readyToExit) {
            System.out.println("Expenses Management System");
            System.out.println("---------------------------");
            System.out.println("e - register new employee");
            System.out.println("c - register new claim");
            System.out.println("p - print all employees");
            System.out.println("x - exit");

            String option = scanner.nextLine();

            switch (option) {
                case "e":
                    Employee e = uiFunctions.registerNewEmployee();
                    employees.addEmployee(e);
                    break;
                case "c":
                    ExpenseClaim claim = uiFunctions.registerNewExpenseClaim();
                    try {
                        employees.addExpenseClaim(claim);
                    } catch (EmployeeNotFoundException ex) {
                        System.out.println("there is no Employee with ID:" + claim.getEmployeeId());
                    }
                    break;
                case "p":
                    employees.printEmployees();
                    break;
                case "x":
                    readyToExit = true;
                    break;
                default:
                    System.out.println("Option is not valid");

            }
        }


    }
}
