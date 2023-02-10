package com.example.SpringcrudDemo.services;

import com.example.SpringcrudDemo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();

    public Optional<Student> findStudentbyRollnum(String Id);

    public void delStudent(String Id);

    public Student updateStudent(Student student,String Id);

    List<Student> findStudentByName(String name);

    List<Student> findStudentByStudentDepartment(String department);
}
