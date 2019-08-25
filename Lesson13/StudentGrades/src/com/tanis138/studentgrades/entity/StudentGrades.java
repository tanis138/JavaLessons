package com.tanis138.studentgrades.entity;

import java.util.*;

public class StudentGrades implements Cloneable {
    public static final char gradesSeparator = ' ';
    public static final char lastNameSeparator = ',';
    public static final char fullNameSeparator = ':';

    private final Student student;
    private ArrayList<Integer> grades;


    public StudentGrades(Student student) throws IllegalArgumentException {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        this.student = student;
        grades = new ArrayList<>();
    }

    public StudentGrades(Student student, List<Integer> grades) throws IllegalArgumentException {
        this(student);

        if (grades == null) {
            throw new IllegalArgumentException("Grades cannot be null");
        }

        if (grades.size() > 0) {
            this.grades.addAll(grades);
        }
    }


    public void addGrade(int grade) {
        grades.add(grade);
    }

    public void addGrades(List<Integer> grades) {
        if (grades == null || grades.size() == 0) {
            return;
        }

        this.grades.addAll(grades);
    }


    public Student getStudent() {
        return student;
    }

    public List<Integer> getGrades() {
        return Collections.unmodifiableList(grades);
    }

    public final double getAverageGrade() {
        try {
            return grades.stream().mapToInt(x -> x).average().orElse(0.0);
        } catch (Exception e) {
            return 0.0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGrades that = (StudentGrades) o;
        return student.equals(that.student) &&
                grades.equals(that.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, grades);
    }

    public final String toStringLine() {
        String s = String.format("%s%c %s", student.getLastName(), lastNameSeparator, student.getFirstName());
        StringBuilder sb = new StringBuilder(String.format("%20s%c ", s, fullNameSeparator));
        sb.ensureCapacity(sb.length() + grades.size());

        for (Integer grade : grades) {
            sb.append(String.format("%2d", grade));
            sb.append(gradesSeparator);
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("%s (avg. %.1f)", toStringLine(), getAverageGrade());
    }

    @Override
    public StudentGrades clone() {
        StudentGrades copy = null;

        try {
            copy = (StudentGrades) super.clone();
            copy.grades = new ArrayList<>(grades);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return copy;
    }
}
