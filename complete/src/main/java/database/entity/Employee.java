package database.entity;

public class Employee {

    private int id;
    private String first_name;
    private String last_name;
    private int salary;

    /* Define constructors for the Employee class. */
    public Employee() {}

    public Employee(String fname, String lname, int salary) {
        this.first_name = fname;
        this.last_name = lname;
        this.salary = salary;
    }

    /* Here are the required method definitions */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String fname) {
        this.first_name = fname;
    }

    public String getLastName() {
        return last_name;
    }

    public void setlastName(String lname) {
        this.last_name = lname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Id = ").append(id).append(" - ");
        sb.append("first_name = ").append(first_name).append(" - ");
        sb.append("last_name = ").append(last_name).append(" - ");
        sb.append("salary = ").append(salary).append(" - ");
        return sb.toString();
    }

} /* End of Employee */
