package com.goundicorp.expenses;

import com.goundicorp.expenses.domain.*;
import com.goundicorp.expenses.exceptions.EmployeeNotFoundException;
import com.goundicorp.expenses.managment.ExpenseManagementProcess;
import com.goundicorp.expenses.managment.ExpressExpenseManagementProcess;
import com.goundicorp.expenses.managment.RegularExpenseManagementProcess;
import com.goundicorp.expenses.ui.UIFunctions;
import com.goundicorp.expenses.utilities.ExpenseAnalyses;
import com.goundicorp.expenses.utilities.ExpenseAnalysisImpl;
import com.goundicorp.expenses.utilities.ExpenseAnalysisTempImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ExpenseManagementSystem {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Employees employees = new EmployeesDatabaseImp();
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
            System.out.println("f - make a file with employees claims");
            System.out.println("a - approve claim");
            System.out.println("r1 - outstanding expense Claim");
            System.out.println("r2 - paid expense claims");
            System.out.println("r3 - expense claims above specified amount");
            System.out.println("x - exit");

            String option = scanner.nextLine();
            ExpenseAnalyses expenseAnalyses = new ExpenseAnalysisImpl(employees);

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
                case "f":
                    List<Employee> employeeList = employees.getEmployeeList();
                    Path report = Paths.get(System.getProperty("user.home") + File.separator + "expenses_report.txt");
                    String lineTerminator = System.getProperty("line.separator");
                    Collections.sort(employeeList);
                    for(Employee emp : employeeList) {
                        Files.writeString(report, emp.toString() + lineTerminator, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                        for (ExpenseClaim empClaim : emp.getClaims().values()) {
                            Files.writeString(report,empClaim.toString() + lineTerminator,StandardOpenOption.APPEND);
                            List<String> claimData = empClaim.getExpenseItems().stream().map(ei -> ei.toString()).toList();
                            Files.write(report,claimData,StandardOpenOption.APPEND);
                            Files.writeString(report, "Total value of claim " + empClaim.getTotalAmount() + lineTerminator, StandardOpenOption.APPEND);
                        }
                    }
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
