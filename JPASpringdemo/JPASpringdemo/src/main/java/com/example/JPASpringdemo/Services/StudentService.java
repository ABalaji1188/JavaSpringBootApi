package com.example.JPASpringdemo.Services;
import com.example.JPASpringdemo.Model.Student;
import com.example.JPASpringdemo.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public List<Student> getAllStudents() {

        return studentRepo.findAll();

    }


    public String addStudent(Student student) {
        studentRepo.save(student);
        return "Added data   successfully ";
    }

    public Student getbyID(int rolno) {

        return studentRepo.findById(rolno).orElse(new Student());
    }

    public String updateStudent(Student student) {

        studentRepo.save(student);
        return "updated data   successfully ";
    }

    public String deleteStudent(int rolno) {

        studentRepo.deleteById(rolno);
        return "deleted data   successfully ";
    }

    public String clearStudent() {

        studentRepo.deleteAll();
        return "cleared all data successfully ";
    }
}
