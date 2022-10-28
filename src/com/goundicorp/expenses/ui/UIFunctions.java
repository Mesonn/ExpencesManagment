package com.goundicorp.expenses.ui;

import com.goundicorp.expenses.domain.*;
import com.goundicorp.expenses.exceptions.InvalidEmployeeIdException;
import com.goundicorp.expenses.exceptions.NameTooShortException;
import com.goundicorp.expenses.utilities.EmployeeUtilities;

import java.time.LocalDate;
import java.util.Scanner;

public class UIFunctions {
    public Employee registerNewEmployee() {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        EmployeeUtilities employeeUtilities = new EmployeeUtilities();



        boolean idIsValid = false;

        while (!idIsValid){
            System.out.println("Enter the id");
            String inputId = scanner.nextLine();
            try {
                Integer id = employeeUtilities.validateEmployeeId(inputId);
                employee.setId(id);
                idIsValid = true;
            } catch (InvalidEmployeeIdException e) {
                System.out.println("Invalid Id try again");
            }
        }

        boolean nameIsValid = false;
        while (!nameIsValid) {


            System.out.println("Enter the firstname");
            String firstname = scanner.nextLine();
            employee.setFirstName(firstname);

            System.out.println("Enter the surname");
            String surname = scanner.nextLine();
            employee.setSurName(surname);

            try {
                employeeUtilities.validateEmployeeName(firstname,surname);
                nameIsValid = true;
            }
            catch (NameTooShortException e){
                System.out.println("the Name is too short enter a longer name pls");
            }

        }
        System.out.println("Enter the title");
        String title = scanner.nextLine();
        employee.setTitle(title);

        boolean departmentIsValid = false;
        while (!departmentIsValid) {
            System.out.println("Enter the Department");
            String department = scanner.nextLine();
            departmentIsValid = true;
            try {
                Department d = Department.valueOf(department.toUpperCase());
                employee.setDepartment(d);
            }catch (IllegalArgumentException e){
                System.out.println("Department you entred was not valid");
            }
        }
        System.out.println("Is this a member of staff? Y/N");
        String isAStaffMember = scanner.nextLine();
        if(isAStaffMember.toUpperCase().equals("Y")){
            StaffEmployee staffEmployee = new StaffEmployee(employee);
            System.out.println("Enter Username");
            String username = scanner.nextLine();
            staffEmployee.setUsername(username);

            System.out.println("Enter password");
            String password = scanner.nextLine();
            staffEmployee.setUsername(password);

            return  staffEmployee;

        }
        else {


            return (employee);

        }
    }
    public ExpenseClaim registerNewExpenseClaim(){
        Scanner scanner = new Scanner(System.in);
        EmployeeUtilities employeeUtilities = new EmployeeUtilities();

        System.out.println("Enter the claim Id");
        int claimId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the employee Id");
        int employeeId = scanner.nextInt();
        scanner.nextLine();

        LocalDate dateOfClaim = LocalDate.now();



        ExpenseClaim claim  = new ExpenseClaim(claimId,employeeId,dateOfClaim);

        boolean finished = false;

        while (!finished){
            System.out.println("Enter the expense item Id");
            int eiId = scanner.nextInt();
            scanner.nextLine();

            boolean expenseTypeIsValid = false;
            ExpenseType eiType = null;
            while (!expenseTypeIsValid) {
                System.out.println("Enter the ExpenseType");
                String expenseType = scanner.nextLine();

                try {
                    eiType = ExpenseType.valueOf(expenseType.toUpperCase());
                    expenseTypeIsValid = true;
                }catch (IllegalArgumentException e){
                    System.out.println("ExpenseType you entred was not valid");
                }
            }

            System.out.println("Enter the Description");
            String description = scanner.nextLine();
            scanner.nextLine();


            System.out.println("Enter the amount");
            double amount = scanner.nextDouble();
            scanner.nextLine();


            ExpenseItem ei = new ExpenseItem(eiId, claimId, eiType,  description,amount  );
            claim.addExpenseItem(ei);

            System.out.println("Enter another expense item? Y/N");
            String anyMore = scanner.nextLine();

            if (! anyMore.toUpperCase().equals("Y")){
                finished = true;
            }






        }



        return claim;

    }



}
