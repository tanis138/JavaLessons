package com.tanis138.studentgrades.logic;

import com.tanis138.studentgrades.entity.Student;
import com.tanis138.studentgrades.entity.StudentGrades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudGenerator {
    private static final int MIN_GRADE = 1;
    private static final int MIN_GOOD_GRADE = 3;
    private static final int MAX_GRADE = 10;

    private static final String[] lastNameMale = {"Ivanov", "Petrov", "Sidorov", "Avnov", "Ovsov", "Prikolov", "Dubov",
            "Lipkin", "Pipkin", "Dripkin", "Berezkin", "Malinkin", "Ogurtsov"};
    private static final String[] firstNameMale = {"Ivan", "Petr", "Oleg", "Alexandr", "Aleksey", "Igor", "Pavel"};
    private static final String[] firstNameFemale = {"Anna", "Olga", "Marina", "Elena", "Ludmila", "Irina", "Vera"};

    private static boolean generateBoolean() {
        return new Random().nextBoolean();
    }

    private static int generateInt(int bound) {
        return new Random().nextInt(bound);
    }

    public static int generateGrade() {
        int minGrade = generateBoolean() ? MIN_GOOD_GRADE : MIN_GRADE;

        return minGrade + generateInt(MAX_GRADE - minGrade + 1);
    }

    public static Student generateStudent() {
        String firstName;
        String lastName = lastNameMale[generateInt(lastNameMale.length)];

        if (generateBoolean()) {
            firstName = firstNameMale[generateInt(firstNameMale.length)];
        } else {
            firstName = firstNameFemale[generateInt(firstNameFemale.length)];
            lastName = lastName + 'a';
        }

        return new Student(firstName, lastName);
    }

    public static List<Integer> generateGrades(int count) {
        count = Math.max(count, 0);
        List<Integer> grades = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            grades.add(generateGrade());
        }

        return grades;
    }

    public static StudentGrades generateStudentGrades(int gradesCount) {
        StudentGrades studentGrades = new StudentGrades(generateStudent());
        studentGrades.addGrades(generateGrades(gradesCount));

        return studentGrades;
    }

    public static List<StudentGrades> generateStudents(int studentsCount, int gradesCount) {
        studentsCount = Math.max(studentsCount, 0);
        gradesCount = Math.max(gradesCount, 0);

        ArrayList<StudentGrades> students = new ArrayList<>(studentsCount);

        for (int i = 0; i < studentsCount; i++) {
            students.add(StudGenerator.generateStudentGrades(gradesCount));
        }

        return students;
    }
}
