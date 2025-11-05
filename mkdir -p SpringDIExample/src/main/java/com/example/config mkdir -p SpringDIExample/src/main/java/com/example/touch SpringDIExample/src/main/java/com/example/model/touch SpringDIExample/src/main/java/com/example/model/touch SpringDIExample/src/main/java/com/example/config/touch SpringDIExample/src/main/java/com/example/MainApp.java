package com.example;

import com.example.config.AppConfig;
import com.example.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Initialize Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve Student bean
        Student student = context.getBean(Student.class);

        // Call method to demonstrate dependency injection
        student.displayCourse();
    }
}
