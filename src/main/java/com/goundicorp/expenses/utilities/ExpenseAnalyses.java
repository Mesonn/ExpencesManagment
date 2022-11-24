package com.goundicorp.expenses.utilities;

import java.time.LocalDate;

public interface ExpenseAnalyses {

    public void printOutstandingClaims();
    public void printPaidClaims(LocalDate from, LocalDate to);
    public void printClaimsOverAmount(Double amount);


}
