package com.heritage.SpringSec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
        new Student(1, "Alice", "A"),
        new Student(2, "Bob", "B"),
        new Student(3, "Charlie", "C")
    ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {
        students.add(student); // ✅ works now
        return "Student added: " + student;
    }
}
