package com.example.SpringSecurity.Model;

public class Student {
    public int rollNo;
    public String Name;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String technology;

    public Student() {
    }

    public Student(int rollNo, String name, String technology) {
        this.rollNo = rollNo;
        Name = name;
        this.technology = technology;
    }
}
