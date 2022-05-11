package com.goundicorp.expenses.ui;

import com.goundicorp.expenses.domain.Department;
import com.goundicorp.expenses.domain.Employee;
import com.goundicorp.expenses.domain.ExpenseClaim;
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

        return (employee);
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

        System.out.println("Enter the amount");
        double totalAmount = scanner.nextDouble();
        scanner.nextLine();

        ExpenseClaim claim  = new ExpenseClaim(claimId,employeeId,dateOfClaim,totalAmount);

        return claim;

    }



}
