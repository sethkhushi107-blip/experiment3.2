package com.example;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        // Create
        Student s1 = new Student("Alice", "alice@example.com");
        Student s2 = new Student("Bob", "bob@example.com");
        dao.createStudent(s1);
        dao.createStudent(s2);

        // Read all
        List<Student> students = dao.getAllStudents();
        System.out.println("All Students:");
        for(Student s : students) {
            System.out.println(s);
        }

        // Update
        s1.setEmail("alice.new@example.com");
        dao.updateStudent(s1);

        // Read single
        Student fetched = dao.getStudent(s1.getId());
        System.out.println("Updated Student: " + fetched);

        // Delete
        dao.deleteStudent(s2.getId());
        System.out.println("After Deletion:");
        students = dao.getAllStudents();
        for(Student s : students) {
            System.out.println(s);
        }

        // Close factory
        StudentDAO.closeFactory();
    }
}
