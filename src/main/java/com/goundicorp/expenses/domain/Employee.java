package com.goundicorp.expenses.domain;

import java.util.*;

public class Employee implements Comparable<Employee>  {

    private int id;
    private String title ;
    private String firstName;
    private String surName;
    private String jobTitle;
    private Department department;

    private Map<Integer ,ExpenseClaim> claims = new HashMap<>();

    public Employee(int id, String title, String firstName, String surName, String jobTitle, Department department) {
        this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.surName = surName;
        this.jobTitle = jobTitle;
        this.department = department;
    }

    public Employee(){
    }
    public Employee (int id ,String jobTitle){
        this.id = id;
        this.jobTitle = jobTitle;
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

    public Map<Integer, ExpenseClaim> getClaims() {
        return claims;
    }

    public void addClaim(ExpenseClaim claim) {
        claims.put(claim.getId(), claim);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(title, employee.title) && Objects.equals(firstName, employee.firstName) && Objects.equals(surName, employee.surName) && Objects.equals(jobTitle, employee.jobTitle) && department == employee.department && Objects.equals(claims, employee.claims);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, firstName, surName, jobTitle, department, claims);
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 2){
            System.out.println("Error! Firstname must be at least 2 characters");
        }else {
        this.firstName = firstName;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", department=" + department +

                '}';
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
    public int compareTo(Employee o) {
        return this.surName.compareTo(o.getSurName());
    }
}
