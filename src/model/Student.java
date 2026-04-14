package model;

import java.util.*;

public class Student {
    private int id;
    private String name;
    private List<Integer> marks;

    public Student(int id, String name, List<Integer> marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public double getAverage() {
        int sum = 0;
        for (int m : marks)
            sum += m;
        return (double) sum / marks.size();
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90)
            return "A";
        else if (avg >= 75)
            return "B";
        else if (avg >= 60)
            return "C";
        else if (avg >= 50)
            return "D";
        else
            return "F";
    }
}