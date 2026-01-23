import java.util.ArrayList;
import java.util.Scanner;

// Abstract base class
abstract class Employee {
    protected int id;
    protected String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}

// Full-time employee class
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(int id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

// Part-time employee class
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int hoursWorked, double hourlyRate) {
        super(id, name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Payroll management system
class PayrollSystem {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee emp) {
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    public void removeEmployee(int id) {
        Employee toRemove = null;

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                toRemove = emp;
                break;
            }
        }

        if (toRemove != null) {
            employees.remove(toRemove);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("--------------------");
        }
    }
}

// Main class
public class EmployeePayrollSystem {
    public static void main(String[] args) {
        PayrollSystem payroll = new PayrollSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int ftId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String ftName = sc.nextLine();
                    System.out.print("Enter Monthly Salary: ");
                    double salary = sc.nextDouble();
                    payroll.addEmployee(new FullTimeEmployee(ftId, ftName, salary));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int ptId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String ptName = sc.nextLine();
                    System.out.print("Enter Hours Worked: ");
                    int hours = sc.nextInt();
                    System.out.print("Enter Hourly Rate: ");
                    double rate = sc.nextDouble();
                    payroll.addEmployee(new PartTimeEmployee(ptId, ptName, hours, rate));
                    break;

                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = sc.nextInt();
                    payroll.removeEmployee(removeId);
                    break;

                case 4:
                    payroll.displayEmployees();
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
