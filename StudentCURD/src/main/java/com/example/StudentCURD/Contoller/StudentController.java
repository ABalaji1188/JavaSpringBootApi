package com.example.StudentCURD.Contoller;

import com.example.StudentCURD.Model.Student;
import com.example.StudentCURD.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping("students")
   public List<Student> GerStudents(){
       return studentService.GetStudent();
   }

   @GetMapping(
           "students/{rno}"
   )
   public  Student GetStudent(@PathVariable("rno") int rollno){
        return studentService.GetByRolNo(rollno);
   }
}
