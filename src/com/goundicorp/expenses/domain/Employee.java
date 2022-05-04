package com.goundicorp.expenses.domain;

public class Employee {
    private int id;
    private String title ;
    private String firstName;
    private String surName;
    private String jobTitle;
    private String department;

    private ExpenseClaim[] claims;

    public Employee(int id, String title, String firstName, String surName, String jobTitle, String department) {
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

    public String getDepartment() {
        return department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void setDepartment(String department) {
        this.department = department;
    }
}
