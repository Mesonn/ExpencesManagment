package com.goundicorp.expenses.domain;

import java.time.LocalDate;
import java.util.Objects;

public class ExpenseClaim {
    private Integer id;
    private  Integer employeeId;
    private LocalDate dateOfClaim;
    private Double totalAmount;
    private  boolean approved, paid;

    public ExpenseClaim(Integer id, Integer employeeId, LocalDate dateOfClaim, Double totalAmount) {
        this.id = id;
        this.employeeId = employeeId;
        this.dateOfClaim = dateOfClaim;
        this.totalAmount = totalAmount;
        this.approved = false ;
        this.paid = false ;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setPaid(boolean paid) {
        if (paid && !approved){
            System.out.println("This item cannot be paid as it has not yrt been approved");
        }
        else{
        this.paid = paid;}

    }

    public Integer getId() {
        return id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public LocalDate getDateOfClaim() {
        return dateOfClaim;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public boolean isApproved() {
        return approved;
    }

    public boolean isPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "ExpenseClaim{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", dateOfClaim='" + dateOfClaim + '\'' +
                ", totalAmount=" + totalAmount +
                ", approved=" + approved +
                ", paid=" + paid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseClaim that = (ExpenseClaim) o;
        return approved == that.approved && paid == that.paid && Objects.equals(id, that.id) && Objects.equals(employeeId, that.employeeId) && Objects.equals(dateOfClaim, that.dateOfClaim) && Objects.equals(totalAmount, that.totalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, dateOfClaim, totalAmount, approved, paid);
    }
}
