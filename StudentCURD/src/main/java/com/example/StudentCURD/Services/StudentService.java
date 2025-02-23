package com.example.StudentCURD.Services;

import com.example.StudentCURD.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> students= new ArrayList<>(
                Arrays.asList(
                        new Student(1,"balaji","Java"),
                        new Student(123,"kumar","APi"),
                        new Student(123,"ravi","sql"),
                        new Student(323,"selvi","c#")

                )
        );


    public List<Student> GetStudent() {
        return students;
    }

    public Student GetByRolNo(int rollno){
        int index=0;
        for (int i=0;i<students.size();i++){
            if(students.get(i).getRollNo()==rollno){
                index=i;
            }
        }
        return students.get(index);
    }

    public  void addStudent(Student stud){
        students.add(stud);
    }

    public void editStudent(Student student) {
        int index=0;
        for (int i=0;i<students.size();i++){
            if(students.get(i).getRollNo()==student.getRollNo()){
                index=i;
            }
        }
         students.set(index,student);
    }

    public void deleteStudent(int rolno) {
        int index=0;
        for (int i=0;i<students.size();i++){
            if(students.get(i).getRollNo()==rolno){
                index=i;
            }
        }
        students.remove(index);
    }
}
