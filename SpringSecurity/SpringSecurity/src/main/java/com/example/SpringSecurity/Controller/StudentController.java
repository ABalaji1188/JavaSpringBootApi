package com.example.SpringSecurity.Controller;

import com.example.SpringSecurity.Model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students;
    public StudentController() {
        students=new ArrayList<>(Arrays.asList(
                new Student(1,"bala","java"),
                new Student(2,"asfd","java"),
                new Student(3,"baasdla","NET"),
                new Student(4,"asdf","PYTHON")

                ));
    }

    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return students;
    }
}
