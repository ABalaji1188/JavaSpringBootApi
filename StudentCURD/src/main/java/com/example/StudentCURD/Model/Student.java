package com.example.StudentCURD.Model;

import lombok.Data;

@Data //try to avoid as it's an anti-pattern
public class Student {


    private int rollNo;

    public Student() {
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    private String name;

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Student(int rollNo, String name, String technology) {
        this.rollNo = rollNo;
        this.name = name;
        this.technology = technology;
    }

    private String technology;
}
