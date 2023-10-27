package com.sujithjeewantha.springbootrestapi.controller;

import com.sujithjeewantha.springbootrestapi.model.dto.Student;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    //http://localhost:8080/students/student
//    @GetMapping("student")
//    public Student getStudent(){
//        Student student = new Student(1,
//                "Sujith",
//                "Jeewantha");
//        return student;
//    }

    //http://localhost:8080/students/student
//    @GetMapping("student")
//    public ResponseEntity<Student> getStudent(){
//        Student student = new Student(1,
//                "Sujith",
//                "Jeewantha");
////        return new ResponseEntity<>(student, HttpStatus.OK);
//        return ResponseEntity.ok(student);
//    }

    // Response Entity with custom header
    //http://localhost:8080/students/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,
                "Sujith",
                "Jeewantha"
        );
        return ResponseEntity.ok()
            .header("customer-header", "sujith")
                .body(student);
    }

    //http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Sujith","Jeewantha"));
        students.add(new Student(2, "Gihan", "Perera"));
        students.add(new Student(3, "Kasun", "Lakshan"));
        students.add(new Student(4, "Nilantha", "Jayawardhana"));

        return ResponseEntity.ok(students);
    }

    //Spring boot rest API with Path Variable
    //http://localhost:8080/students/1
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    //Spring boot REST API with Request Param
    //http://localhost:8080/students/query?id=1&firstName=Sujith&lastName=Jeewantha
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    //Sping boot REST API that handles HTTP POST Request
    //@PostMapping & @RequestBody
    //http://localhost:8080/students/create
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
    return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //Sping boot REST API that handles HTTP PUT Request - Updating the existing record
    //http://localhost:8080/students/create
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int satudentId){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    //Spring boot REST API HTTP DELETE Request - deleting the existing resources
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok( "Student deleted successfully");
    }
}