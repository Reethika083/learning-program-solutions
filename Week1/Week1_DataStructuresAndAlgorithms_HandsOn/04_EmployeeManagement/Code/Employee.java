public class Employee {
    private String empId;
    private String name;
    private String department;
    private double salary;

    public Employee(String empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee[ID=" + empId + ", Name=" + name +
                ", Dept=" + department + ", Salary=$" + salary + "]";
    }
}
