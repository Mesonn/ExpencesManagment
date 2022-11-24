package com.goundicorp.expenses.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExpenseClaim {
    private Integer id;
    private  Integer employeeId;
    private LocalDate dateOfClaim;

    private  boolean approved, paid;

    private List<ExpenseItem> expenseItems;


    public List<ExpenseItem> getExpenseItems() {
        return expenseItems;
    }

    public ExpenseClaim(Integer id, Integer employeeId, LocalDate dateOfClaim) {
        this.id = id;
        this.employeeId = employeeId;
        this.dateOfClaim = dateOfClaim;
        this.approved = false ;
        this.paid = false ;
        this.expenseItems = new ArrayList<>();
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

    public void addExpenseItem(ExpenseItem item){
        expenseItems.add(item);
    }
    public void printExpenseItems(){
        for(ExpenseItem ei : expenseItems){
            System.out.println(ei);
        }
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
        Double total = 0d;

        for (ExpenseItem ei: expenseItems ) {
            total += ei.getAmount();
        }

        return total;
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
                ", approved=" + approved +
                ", paid=" + paid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseClaim that = (ExpenseClaim) o;
        return approved == that.approved && paid == that.paid && Objects.equals(id, that.id) && Objects.equals(employeeId, that.employeeId) && Objects.equals(dateOfClaim, that.dateOfClaim) && Objects.equals(expenseItems, that.expenseItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, dateOfClaim, approved, paid, expenseItems);
    }
}
