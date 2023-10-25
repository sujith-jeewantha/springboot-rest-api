package com.sujithjeewantha.springbootrestapi.controller;

import com.sujithjeewantha.springbootrestapi.model.dto.Student;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(1,
                "Sujith",
                "Jeewantha");
        return student;
    }

    //http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Sujith","Jeewantha"));
        students.add(new Student(2, "Gihan", "Perera"));
        students.add(new Student(3, "Kasun", "Lakshan"));
        students.add(new Student(4, "Nilantha", "Jayawardhana"));

        return students;
    }
}
