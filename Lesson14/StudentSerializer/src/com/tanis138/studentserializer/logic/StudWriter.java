package com.tanis138.studentserializer.logic;

import com.tanis138.studentserializer.entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudWriter {

    public static boolean saveToFile(List<Student> students, String fileName, boolean append) {
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
                System.err.println("saveToFile: " + e);
                return false;
            }
        }

        // write data into file
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName, append)))) {
            oos.writeInt(students.size());
            for (Student student : students) {
                oos.writeObject(student);
            }
            return true;
        } catch (IOException e) {
            System.err.println("saveToFile: " + e);
            return false;
        }
    }

    public static List<Student> loadFromFile(String fileName) {
        ArrayList<Student> res = null;

        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            int count = ois.readInt();
            res = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                try {
                    res.add((Student) ois.readObject());
                } catch (ClassNotFoundException e) {
                    System.err.printf("loadFromFile: Load student #%d error - %s\n", i, e);
                }
            }
        } catch (IOException e) {
            System.err.println("loadFromFile: " + e);
        }

        return res;
    }
}
