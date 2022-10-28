package com.goundicorp.expenses.utilities;

import java.time.LocalDate;

public class ExpenseAnalysisTempImpl implements ExpenseAnalyses{
    @Override
    public void printOutstandingClaims() {
        System.out.println("feature not aviable");
    }

    @Override
    public void printPaidClaims(LocalDate from, LocalDate to) {
        System.out.println("feature not aviable");
    }

    @Override
    public void printClaimsOverAmount(Double amount) {
        System.out.println("feature not aviable");
    }
}
