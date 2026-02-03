import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.size();
    }

    int getHighest() {
        if (grades.isEmpty()) return 0;
        int max = grades.get(0);
        for (int g : grades) if (g > max) max = g;
        return max;
    }

    int getLowest() {
        if (grades.isEmpty()) return 0;
        int min = grades.get(0);
        for (int g : grades) if (g < min) min = g;
        return min;
    }

    void displayReport() {
        System.out.println("Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest: " + getLowest());
        System.out.println("---------------------------------");
    }
}

public class StudentGradeTracker {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade to Student");
            System.out.println("3. Display All Students Report");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addGrade();
                    break;
                case 3:
                    displayAllReports();
                    break;
                case 4:
                    System.out.println("Exiting Program... Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        students.add(new Student(name));
        System.out.println("Student added successfully!");
    }

    static void addGrade() {
        if (students.isEmpty()) {
            System.out.println("No students found. Add students first.");
            return;
        }

        System.out.println("Select Student:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).name);
        }

        System.out.print("Enter student number: ");
        int index = sc.nextInt() - 1;

        if (index < 0 || index >= students.size()) {
            System.out.println("Invalid student selection!");
            return;
        }

        System.out.print("Enter grade: ");
        int grade = sc.nextInt();
        students.get(index).addGrade(grade);
        System.out.println("Grade added successfully!");
    }

    static void displayAllReports() {
        if (students.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }

        System.out.println("\n===== STUDENT SUMMARY REPORT =====");
        for (Student s : students) {
            s.displayReport();
        }
    }
}
