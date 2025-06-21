public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee("E001", "Riya", "HR", 45000));
        manager.addEmployee(new Employee("E002", "Aarav", "Tech", 65000));
        manager.addEmployee(new Employee("E003", "Zoya", "Finance", 70000));

        manager.viewAll();

        double avg = manager.averageSalary();
        System.out.printf("\n📊 Average Salary: $%.2f\n", avg);
    }
}
