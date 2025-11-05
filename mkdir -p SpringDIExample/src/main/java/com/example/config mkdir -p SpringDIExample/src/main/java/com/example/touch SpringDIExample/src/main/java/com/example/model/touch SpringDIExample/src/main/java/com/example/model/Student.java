package com.example.model;

public class Student {
    private Course course;

    // Constructor-based DI
    public Student(Course course) {
        this.course = course;
    }

    public void displayCourse() {
        System.out.println("Enrolled in: " + course.getCourseName());
    }
}
