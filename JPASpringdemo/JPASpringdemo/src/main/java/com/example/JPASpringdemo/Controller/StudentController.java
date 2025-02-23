package com.example.JPASpringdemo.Controller;

import com.example.JPASpringdemo.Model.Student;
import com.example.JPASpringdemo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{roln}")
    public  Student GetbyId(@PathVariable int roln){
        return studentService.getbyID(roln);
    }

    @PostMapping("/student")
    public String add(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/student")
    public String updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/student/{roln}")
    public String deleteStudent(@PathVariable int roln){
        return studentService.deleteStudent(roln);
    }

    @DeleteMapping("/student/clear")
    public String deleteAllStudent(){
        return studentService.clearStudent();
    }
}
