package view;

import model.Student;
import java.util.*;

public class StudentView {

    Scanner sc = new Scanner(System.in);

    public int menu() {
        System.out.println("\n--- Student Management System ---");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
        return Integer.parseInt(sc.nextLine());
    }

    public Student getStudentInput() {
        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter number of subjects: ");
            int n = Integer.parseInt(sc.nextLine());

            List<Integer> marks = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                System.out.print("Enter mark " + (i + 1) + ": ");
                marks.add(Integer.parseInt(sc.nextLine()));
            }

            return new Student(id, name, marks);
        } catch (Exception e) {
            System.out.println("Invalid input!");
            return null;
        }
    }

    public int getIdInput() {
        System.out.print("Enter ID: ");
        return Integer.parseInt(sc.nextLine());
    }

    public void displayStudent(Student s) {
        System.out.println("\nID: " + s.getId());
        System.out.println("Name: " + s.getName());
        System.out.println("Marks: " + s.getMarks());
        System.out.println("Average: " + s.getAverage());
        System.out.println("Grade: " + s.getGrade());
    }

    public void displayAll(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        for (Student s : students) {
            displayStudent(s);
        }
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}