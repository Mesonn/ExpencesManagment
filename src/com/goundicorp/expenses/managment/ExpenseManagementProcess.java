package com.goundicorp.expenses.managment;

import com.goundicorp.expenses.domain.Employee;
import com.goundicorp.expenses.domain.ExpenseClaim;

public interface ExpenseManagementProcess {

    public int registerExpenseClaim(ExpenseClaim claim);
    public  boolean approveClaim(int id, Employee employee);

}
