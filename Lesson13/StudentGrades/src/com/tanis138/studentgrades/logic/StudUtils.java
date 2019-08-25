package com.tanis138.studentgrades.logic;

import com.tanis138.studentgrades.entity.Student;
import com.tanis138.studentgrades.entity.StudentGrades;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudUtils {
    public static final double GOOD_AVERAGE_GRADE = 7.0;

    private static final Comparator<StudentGrades> lastNameComparator = Comparator.comparing(a -> a.getStudent().getLastName());
    private static final Comparator<StudentGrades> firstNameComparator = Comparator.comparing(a -> a.getStudent().getFirstName());
    public static final Comparator<StudentGrades> studentGradesComparator = lastNameComparator.thenComparing(firstNameComparator);

    public static StudentGrades parse(String line) {
        if (line == null || line.length() == 0) return null;

        String regex = String.format("[\\s]*[%c|%c][\\s]*", StudentGrades.lastNameSeparator, StudentGrades.fullNameSeparator);
        String[] fields = line.split(regex);
//        System.out.println(Arrays.toString(fields));
        if (fields.length < 2) return null;

        String lastName = fields[0].trim();
        String firstName = fields[1].trim();
        if (firstName.isEmpty() || lastName.isEmpty()) return null;

        StudentGrades res = new StudentGrades(new Student(firstName, lastName));

        if (fields.length == 2) return res;

        regex = String.format("[\\s]*[%c][\\s]*", StudentGrades.gradesSeparator);
        String[] grades = fields[2].split(regex);
//        System.out.println(Arrays.toString(grades));
        for (String grade : grades) {
            try {
                res.addGrade(Integer.parseInt(grade));
            } catch (NumberFormatException e) {
                //e.printStackTrace();
            }
        }

        return res;
    }

    private static StudentGrades upperCaseGoodAverage(StudentGrades sg) {
        if (sg.getAverageGrade() > GOOD_AVERAGE_GRADE) {
            Student student = new Student(sg.getStudent().getFirstName().toUpperCase(),
                    sg.getStudent().getLastName().toUpperCase());
            return new StudentGrades(student, sg.getGrades());
        } else {
            return sg;
        }
    }

    public static List<StudentGrades> toUpperCaseGoodGrades(List<StudentGrades> grades) {
        if (grades == null) return null;
        if (grades.size() == 0) return grades;

        return grades
                .stream()
                .map(StudUtils::upperCaseGoodAverage)
                .collect(Collectors.toList());
    }
}
