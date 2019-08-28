package com.tanis138.studentserializer.entity;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private final String firstName;
    private final String lastName;
    private final int age;
    private final Gender gender;


    public Student(String firstName, String lastName, int age, Gender gender) throws IllegalArgumentException {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("Student name cannot be null");
        }
        this.firstName = firstName;
        this.lastName = lastName;

        if (gender == null) {
            throw new IllegalArgumentException("Student gender cannot be null");
        }
        this.gender = gender;

        if (age < 1) {
            throw new IllegalArgumentException("Student age must be a positive number");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                firstName.equals(student.firstName) &&
                lastName.equals(student.lastName) &&
                gender == student.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, gender);
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s, %dyrs)", lastName, firstName, gender.toString().toLowerCase(), age);
    }

    @Override
    public Student clone() {
        Student copy = null;

        try {
            copy = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return copy;
    }
}
