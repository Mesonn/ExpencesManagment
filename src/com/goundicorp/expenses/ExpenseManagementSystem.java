package com.goundicorp.expenses;

import com.goundicorp.expenses.domain.Employee;
import com.goundicorp.expenses.domain.Employees;
import com.goundicorp.expenses.domain.ExpenseClaim;
import com.goundicorp.expenses.exceptions.EmployeeNotFoundException;
import com.goundicorp.expenses.managment.ExpenseManagementProcess;
import com.goundicorp.expenses.managment.ExpressExpenseManagementProcess;
import com.goundicorp.expenses.managment.RegularExpenseManagementProcess;
import com.goundicorp.expenses.ui.UIFunctions;
import com.goundicorp.expenses.utilities.ExpenseAnalyses;
import com.goundicorp.expenses.utilities.ExpenseAnalysisTempImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class ExpenseManagementSystem {
    public static void main(String[] args) {
        Employees employees = new Employees();
        Scanner scanner = new Scanner(System.in);
        UIFunctions uiFunctions = new UIFunctions();

        ExpenseManagementProcess expressEMP = new ExpressExpenseManagementProcess();
        ExpenseManagementProcess regularEMP = new RegularExpenseManagementProcess();


        boolean readyToExit = false;

        while (!readyToExit) {
            System.out.println("Expenses Management System");
            System.out.println("---------------------------");
            System.out.println("e - register new employee");
            System.out.println("c - register new claim");
            System.out.println("p - print all employees");
            System.out.println("a - approve claim");
            System.out.println("r1 - outstanding expense Claim");
            System.out.println("r2 - paid expense claims");
            System.out.println("r3 - expense claims above specified amount");
            System.out.println("x - exit");

            String option = scanner.nextLine();
            ExpenseAnalyses expenseAnalyses = new ExpenseAnalysisTempImpl();

            switch (option) {
                case "e":
                    Employee e = uiFunctions.registerNewEmployee();
                    employees.addEmployee(e);
                    break;
                case "c":
                    ExpenseClaim claim = uiFunctions.registerNewExpenseClaim();
                    try {
                        employees.addExpenseClaim(claim);
                        expressEMP.registerExpenseClaim(claim);
                        regularEMP.registerExpenseClaim(claim);
                        int id = regularEMP.registerExpenseClaim(claim);
                        System.out.println("The claim has been registred with Id =" + id);
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
                case "a":
                    System.out.println("Enter the claim Id");
                    int claimId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter the Employee Id");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine();

                    Employee foundEmployee = employees.findByID(employeeId);

                    System.out.println("Enter r for regular, or e for express");
                    String claimType = scanner.nextLine();

                    ExpenseManagementProcess requestedProcess;

                    if(claimType.equals("r")){
                        requestedProcess = regularEMP;
                    }
                    else {
                        requestedProcess = expressEMP;
                    }

                    boolean result = requestedProcess.approveClaim(claimId,foundEmployee);
                    System.out.println("The result was " + result);

                case "r1":
                    expenseAnalyses.printOutstandingClaims();

                    break;

                case "r2":
                    System.out.println("Enter date from");
                    String dateFrom = scanner.nextLine();
                        scanner.nextLine();
                    System.out.println("Enter date to");
                    String dateTo = scanner.nextLine();
                    scanner.nextLine();


                    expenseAnalyses.printPaidClaims(LocalDate.parse(dateFrom),LocalDate.parse(dateTo));

                    break;

                case "r3":
                    System.out.println("Enter amount");
                    Double amount = scanner.nextDouble();
                    scanner.nextLine();



                    expenseAnalyses.printClaimsOverAmount(amount);

                default:
                    System.out.println("Option is not valid");

            }

        }


    }
}
