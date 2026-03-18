import java.util.ArrayList;

// Abstract Employee class
abstract class Employee { 
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Abstract method
    public abstract double calculateSalary();

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + calculateSalary());
    }
}

// Full Time Employee class
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    public double calculateSalary() {
        return monthlySalary;
    }
}

// Part Time Employee class
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Payroll System class
class PayrollSystem {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                employeeToRemove = emp;
                break;
            }
        }

        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Display all employees
    public void displayEmployees() {
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("------------------");
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        PayrollSystem payroll = new PayrollSystem();

        payroll.addEmployee(new FullTimeEmployee("Akanksha", 1, 30000));
        payroll.addEmployee(new PartTimeEmployee("Kavya", 2, 40, 200));

        System.out.println("\nEmployee Details:");
        payroll.displayEmployees();

        payroll.removeEmployee(1);

        System.out.println("\nAfter Removing Employee ID 1:");
        payroll.displayEmployees();
    }
}
