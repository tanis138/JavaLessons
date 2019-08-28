package com.tanis138.studentserializer.logic;

import com.tanis138.studentserializer.entity.Gender;
import com.tanis138.studentserializer.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudGenerator {
    private static final int MIN_AGE = 17;
    private static final int AGE_BOUND = 10;

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

    public static Student generateStudent() {
        String firstName;
        String lastName = lastNameMale[generateInt(lastNameMale.length)];
        int age = MIN_AGE + generateInt(AGE_BOUND);
        Gender gender;

        if (generateBoolean()) {
            firstName = firstNameMale[generateInt(firstNameMale.length)];
            gender = Gender.MALE;
        } else {
            firstName = firstNameFemale[generateInt(firstNameFemale.length)];
            lastName = lastName + 'a';
            gender = Gender.FEMALE;
        }

        return new Student(firstName, lastName, age, gender);
    }

    public static List<Student> generateStudents(int studentsCount) {
        studentsCount = Math.max(studentsCount, 0);

        ArrayList<Student> students = new ArrayList<>(studentsCount);

        for (int i = 0; i < studentsCount; i++) {
            students.add(StudGenerator.generateStudent());
        }

        return students;
    }
}
