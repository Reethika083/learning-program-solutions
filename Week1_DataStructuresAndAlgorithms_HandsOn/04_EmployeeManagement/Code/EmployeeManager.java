public class EmployeeManager {
    private Employee[] employees;
    private int count;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count++] = e;
            System.out.println("✅ Added: " + e);
        } else {
            System.out.println("❌ Cannot add more employees. Array full!");
        }
    }

    public void viewAll() {
        System.out.println("👩‍💼 All Employees:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public double averageSalary() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += employees[i].getSalary();
        }
        return (count > 0) ? total / count : 0;
    }
}
