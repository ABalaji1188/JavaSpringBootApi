package com.example.StudentCURD.Contoller;

import com.example.StudentCURD.Model.Student;
import com.example.StudentCURD.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

   @PostMapping("students")
   public String addStudent(@RequestBody Student student)
   {
        studentService.addStudent(student);
       String s = "add succefully";
       return s;
   }

    @PutMapping("students")
    public String editStudent(@RequestBody Student student)
    {
        studentService.editStudent(student);
        String s = "Edited succefully";
        return s;
    }
    @DeleteMapping("students/{rolno}")
    public  String deleteStudent(@PathVariable("rolno")int rolno){
        studentService.deleteStudent(rolno);
        return "deleted succefully";
    }
}
