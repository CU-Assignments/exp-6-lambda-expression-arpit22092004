import java.util.*;

// Employee Class
class Employee {
    private String name;
    private int age;
    private double salary;

    // Constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    // Display Employee Details
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Salary: $" + salary;
    }
}

public class EmployeeSorter {

    public static void main(String[] args) {
        // List of Employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ayush", 30, 80000));
        employees.add(new Employee("Babita", 25, 75000));
        employees.add(new Employee("Chandan", 35, 90000));
        employees.add(new Employee("Deva", 28, 85000));
        employees.add(new Employee("Prince", 30, 80000));

        System.out.println("Original List:");
        employees.forEach(System.out::println);

        // Sort by Name
        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("\nSorted by Name:");
        employees.forEach(System.out::println);

        // Sort by Age
        employees.sort(Comparator.comparing(Employee::getAge));
        System.out.println("\nSorted by Age:");
        employees.forEach(System.out::println);

        // Sort by Salary
        employees.sort(Comparator.comparing(Employee::getSalary));
        System.out.println("\nSorted by Salary:");
        employees.forEach(System.out::println);
    }
}
