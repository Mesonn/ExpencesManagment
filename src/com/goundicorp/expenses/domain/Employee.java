package com.goundicorp.expenses.domain;

import java.util.Arrays;
import java.util.Objects;

public class Employee {
    private int id;
    private String title ;
    private String firstName;
    private String surName;
    private String jobTitle;
    private Department department;

    private ExpenseClaim[] claims;

    public Employee(int id, String title, String firstName, String surName, String jobTitle, Department department) {
        this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.surName = surName;
        this.jobTitle = jobTitle;
        this.department = department;
    }

    public Employee(){
        claims = new ExpenseClaim[10];

    }
    public Employee (int id ,String jobTitle){
        this.id = id;
        this.jobTitle = jobTitle;
        claims = new ExpenseClaim[10];
    }


    public String getMailingName(){
        return  title + " " + firstName + " " + surName;
    }

    public String getMailingName(boolean firstInitialOnly){
        if (firstInitialOnly){
            return title + " " + firstName.substring(0,1) + " " + surName;
        }
        else {
            return title + " "+ surName;
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Department getDepartment() {
        return department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ExpenseClaim[] getClaims() {
        return claims;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 2){
            System.out.println("Error! Firstname must be at least 2 characters");
        }else {
        this.firstName = firstName;
        }
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", department='" + department + '\'' +
                ", claims=" + Arrays.toString(claims) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(title, employee.title) && Objects.equals(firstName, employee.firstName) && Objects.equals(surName, employee.surName) && Objects.equals(jobTitle, employee.jobTitle) && Objects.equals(department, employee.department) && Arrays.equals(claims, employee.claims);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, firstName, surName, jobTitle, department);
        result = 31 * result + Arrays.hashCode(claims);
        return result;
    }
}
