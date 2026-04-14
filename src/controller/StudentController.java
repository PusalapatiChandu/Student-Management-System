package controller;

import model.Student;
import view.StudentView;
import java.util.*;

public class StudentController {

    private List<Student> students = new ArrayList<>();
    private StudentView view = new StudentView();

    public void start() {
        while (true) {
            try {
                int choice = view.menu();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        view.displayAll(students);
                        break;
                    case 3:
                        searchStudent();
                        break;
                    case 4:
                        updateStudent();
                        break;
                    case 5:
                        deleteStudent();
                        break;
                    case 6:
                        view.showMessage("Exiting...");
                        return;
                    default:
                        view.showMessage("Invalid choice!");
                }

            } catch (Exception e) {
                view.showMessage("Error occurred!");
            }
        }
    }

    private void addStudent() {
        Student s = view.getStudentInput();
        if (s == null)
            return;

        for (Student st : students) {
            if (st.getId() == s.getId()) {
                view.showMessage("ID already exists!");
                return;
            }
        }

        students.add(s);
        view.showMessage("Student added successfully!");
    }

    private void searchStudent() {
        int id = view.getIdInput();

        for (Student s : students) {
            if (s.getId() == id) {
                view.displayStudent(s);
                return;
            }
        }

        view.showMessage("Student not found!");
    }

    private void updateStudent() {
        int id = view.getIdInput();

        for (Student s : students) {
            if (s.getId() == id) {
                view.showMessage("Enter new details:");
                Student updated = view.getStudentInput();
                if (updated == null)
                    return;

                s.setName(updated.getName());
                s.setMarks(updated.getMarks());

                view.showMessage("Updated successfully!");
                return;
            }
        }

        view.showMessage("Student not found!");
    }

    private void deleteStudent() {
        int id = view.getIdInput();

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                view.showMessage("Deleted successfully!");
                return;
            }
        }

        view.showMessage("Student not found!");
    }
}