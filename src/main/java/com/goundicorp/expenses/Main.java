package com.goundicorp.expenses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goundicorp.expenses.domain.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setTitle("Mr");
        employee1.setFirstName("Dali");
        employee1.setSurName("Goundi");
        EmployeesInMemoryImpl employees = new EmployeesInMemoryImpl();
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

        ExpenseClaim expenseClaim = new ExpenseClaim(24,444, LocalDate.now());
        System.out.println(expenseClaim.getEmployeeId());
        expenseClaim.setPaid(true);
        System.out.println(expenseClaim.isPaid());
        expenseClaim.setApproved(true);
        expenseClaim.setPaid(true);
        System.out.println(expenseClaim.isPaid());
        employees.printEmployees();
        ExpenseItem expenseItem = new ExpenseItem(24,588, ExpenseType.ACCOMODATION,"Hotel Duisburg", 500.0);

        ObjectMapper objectMapper = new ObjectMapper();
        String emplJS = objectMapper.writeValueAsString(employee1);

        System.out.println(emplJS);


        StaffEmployee emplfromJS = objectMapper.readValue(emplJS,StaffEmployee.class);
        System.out.println(emplfromJS);
        //System.out.println(employee1.toString());
    }
}
