package com.tanis138.studentgrades;

import com.tanis138.studentgrades.entity.StudentGrades;
import com.tanis138.studentgrades.logic.StudGenerator;
import com.tanis138.studentgrades.logic.StudUtils;
import com.tanis138.studentgrades.logic.StudWriter;

import java.io.File;
import java.util.List;

class StudentGradesRunner {
    private static final int GRADES_COUNT = 10;
    private static final int STUDENTS_COUNT = 30;
    private static final String STUDENT_GRADES_IN_FILE = "./data/StudGradesIn.txt";
    private static final String STUDENT_GRADES_OUT_FILE = "./data/StudGradesOut.txt";

    public static void main(String[] args) {
        boolean isOk;

        // generate student grades if file not exists
        if (!(new File(STUDENT_GRADES_IN_FILE).exists())) {
            List<StudentGrades> genStudents = StudGenerator.generateStudents(STUDENTS_COUNT, GRADES_COUNT);
            isOk = StudWriter.saveToFile(genStudents, STUDENT_GRADES_IN_FILE, false);
            System.out.printf("Creating \"%s\"... %s%n", STUDENT_GRADES_IN_FILE, isOk ? "Ok!" : "Error!");
            if (!isOk) return;
        }

        // load student grades from file
        List<StudentGrades> studList = StudWriter.loadFromFile(STUDENT_GRADES_IN_FILE);
        isOk = (studList != null);
        System.out.printf("Loading \"%s\"... %s%n", STUDENT_GRADES_IN_FILE, isOk ? "Ok!" : "Error!");
        if (!isOk) return;

        // uppercase students with good average grade
        studList = StudUtils.toUpperCaseGoodGrades(studList);

        System.out.printf("List of grades (uppercase if average grade > %.0f): \n", StudUtils.GOOD_AVERAGE_GRADE);
        studList.forEach(System.out::println);

        // save changed student grades from file
        isOk = StudWriter.saveToFile(studList, STUDENT_GRADES_OUT_FILE, false);
        System.out.printf("Saving \"%s\"... %s%n", STUDENT_GRADES_OUT_FILE, isOk ? "Ok!" : "Error!");
    }
}
