package com.example.SpringcrudDemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Student {
    @Id
    String rollNum;
    String name;
    String department;
    Date date;

    public Student() {
    }

    public Student(String rollNum, String name, String department, Date date) {
        this.rollNum = rollNum;
        this.name = name;
        this.department = department;
        this.date = date;
    }

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNum='" + rollNum + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", date=" + date +
                '}';
    }
}
