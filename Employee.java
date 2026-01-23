import java.util.ArrayList;
// Employee class
abstract class Employee {
    int id;
    String name;
    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    abstract double calculateSalary();
    void display() {
        System.out.println(id + "  " + name + "  Salary: " + calculateSalary());
    }
}
// Full Time Employee
class FullTimeEmployee extends Employee {
    double salary;
    FullTimeEmployee(int id, String name, double salary) {
        super(id, name);
        this.salary = salary;
    }
    double calculateSalary() {
        return salary;
    }
}
// Part Time Employee
class PartTimeEmployee extends Employee {
    int hours;
    double rate;
    PartTimeEmployee(int id, String name, int hours, double rate) {
        super(id, name);
        this.hours = hours;
        this.rate = rate;
    }
    double calculateSalary() {
        return hours * rate;
    }
}
// Payroll class
class Payroll {
    ArrayList<Employee> list = new ArrayList<>();
    void addEmployee(Employee e) {
        list.add(e);
    }
    void removeEmployee(int id) {
        for (Employee e : list) {
            if (e.id == id) {
                list.remove(e);
                break;
            }
        }
    }
    void displayEmployees() {
        for (Employee e : list) {
            e.display();
        }
    }
}
// Main class
public class Main {
    public static void main(String[] args) {
        Payroll payroll = new Payroll();
        payroll.addEmployee(new FullTimeEmployee(1, "Akanksha", 30000));
        payroll.addEmployee(new PartTimeEmployee(2, "Kavya", 40, 200));
        System.out.println("Employee Details:");
        payroll.displayEmployees();
        payroll.removeEmployee(1);
        System.out.println("\nAfter Removing Employee ID 1:");
        payroll.displayEmployees();
    }
}
