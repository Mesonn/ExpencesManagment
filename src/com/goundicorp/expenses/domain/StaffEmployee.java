package com.goundicorp.expenses.domain;

import java.util.Objects;

public class StaffEmployee extends Employee implements Comparable<Employee>{
    private  String username;
    private  String password;

    public StaffEmployee(Employee e){
        super(e.getId(), e.getTitle(),e.getFirstName(),e.getSurName(),e.getJobTitle(),e.getDepartment());
    }
    public StaffEmployee (){
        super();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StaffEmployee that = (StaffEmployee) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, password);
    }
}
