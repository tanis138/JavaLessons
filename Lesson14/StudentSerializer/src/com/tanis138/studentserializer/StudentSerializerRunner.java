package com.tanis138.studentserializer;

import com.tanis138.studentserializer.entity.Student;
import com.tanis138.studentserializer.logic.StudGenerator;
import com.tanis138.studentserializer.logic.StudWriter;

import java.util.List;
import java.util.Scanner;

public class StudentSerializerRunner {
    private static final int STUDENTS_COUNT = 30;
    private static final String STUDENTS_FILE = "./data/Students.bin";
    private static final int MAX_N = 2;

    private static void GenerateAndSaveStudents() {
        List<Student> genStudents = StudGenerator.generateStudents(STUDENTS_COUNT);

        boolean isOk = StudWriter.saveToFile(genStudents, STUDENTS_FILE, false);
        System.out.printf("Creating \"%s\"... %s%n", STUDENTS_FILE, isOk ? "Ok!" : "Error!");
    }

    private static void LoadAndListStudents() {
        List<Student> studList = StudWriter.loadFromFile(STUDENTS_FILE);
        boolean isOk = (studList != null);
        System.out.printf("Loading \"%s\"... %s%n", STUDENTS_FILE, isOk ? "Ok!" : "Error!");
        if (!isOk) return;

        System.out.println("\nList of students: ");
        studList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMain menu: ");
            System.out.println("\t1. Create and save students list to file.");
            System.out.println("\t2. Load students list from file.");
            System.out.println();

            int n;
            do {
                System.out.print("Type menu number (or 0 to return): ");
                try {
                    n = Integer.parseInt(sc.next().trim());
                } catch (NumberFormatException e) {
                    n = -1;
                }
            } while (n < 0 || n > MAX_N);

            switch (n) {
                case 0:
                    sc.close();
                    return;
                case 1:
                    GenerateAndSaveStudents();
                    break;
                case 2:
                    LoadAndListStudents();
                    break;
            }
        }

    }
}
