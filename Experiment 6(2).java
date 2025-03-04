import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 72),
            new Student("Charlie", 90),
            new Student("David", 65),
            new Student("Eve", 78)
        );

        students.stream()
            .filter(s -> s.getMarks() > 75)   // Filter students scoring above 75%
            .sorted(Comparator.comparingInt(Student::getMarks).reversed()) // Sort by marks in descending order
            .map(Student::getName)  // Extract names
            .forEach(System.out::println);  // Display names
    }
}
