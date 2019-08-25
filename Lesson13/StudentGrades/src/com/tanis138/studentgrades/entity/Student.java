package com.tanis138.studentgrades.entity;

import java.util.Objects;

public class Student implements Cloneable {
    private final String firstName;
    private final String lastName;


    public Student(String firstName, String lastName) throws IllegalArgumentException {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("Student name cannot be null");
        }

        this.firstName = firstName;
        this.lastName = lastName;
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
        return firstName.equals(student.firstName) &&
                lastName.equals(student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return lastName + ' ' + firstName;
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
