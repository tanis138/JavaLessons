package com.tanis138.studentgrades.logic;

import com.tanis138.studentgrades.entity.StudentGrades;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudWriter {

    public static boolean saveToFile(List<StudentGrades> students, String fileName, boolean append) {
        File f = new File(fileName);
        File dir = f.getParentFile();

        // create dir(s) if necessary
        if (dir != null && !dir.exists()) {
            if (!dir.mkdirs()) {
                System.err.println("saveToFile: Create directory(s) error!");
                return false;
            }
        }

        // create file if necessary
        if (!f.exists()) {
            try {
                if (!f.createNewFile()) return false;
            } catch (IOException e) {
                System.err.println("saveToFile: Create file error - " + e);
                return false;
            }
        }

        // write data into file
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f, append)))) {
//            students.stream().sorted(StudUtils.studentGradesComparator).forEach(x -> pw.println(x.toStringLine()));
            students.forEach(x -> pw.println(x.toStringLine()));
            return true;
        } catch (IOException e) {
            System.err.println("saveToFile: Write file error - " + e);
            return false;
        }
    }

    public static List<StudentGrades> loadFromFile(String fileName) {
        ArrayList<StudentGrades> res = null;

        try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
            res = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                StudentGrades sg = StudUtils.parse(line);
                if (sg != null) res.add(sg);
            }
        } catch (FileNotFoundException e) {
            System.err.println("loadFromFile: Load file error -" + e);
        } catch (IOException e) {
            System.err.println("loadFromFile: Read file error - " + e);
        }

        return res;
    }
}
