public class Employee {
    private int id;
    private String title ;
    private String firstName;
    private String surName;
    private String jobTitle;
    private String department;

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
