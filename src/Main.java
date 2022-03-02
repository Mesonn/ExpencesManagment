public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setTitle("Mr");
        employee1.setFirstName("Dali");
        employee1.setSurName("Goundi");


        System.out.println(employee1.getMailingName());
        System.out.println(employee1.getMailingName(true));
        System.out.println(employee1.getMailingName(false ));

        Employee employee2 = new Employee(2,"Manager");
        ExpenseClaim expenseClaim = new ExpenseClaim(24,444,"20-04-1980",300.0);
        System.out.println(expenseClaim.getEmployeeId());
        expenseClaim.setPaid(true);
        System.out.println(expenseClaim.isPaid());
        expenseClaim.setApproved(true);
        expenseClaim.setPaid(true);
        System.out.println(expenseClaim.isPaid());

        ExpenseItem expenseItem = new ExpenseItem(24,588, "Hotel","Hotel Duisburg", 500.0);
    }
}
