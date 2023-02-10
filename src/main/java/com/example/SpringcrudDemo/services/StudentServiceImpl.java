package com.example.SpringcrudDemo.services;

import com.example.SpringcrudDemo.dao.StudentDao;
import com.example.SpringcrudDemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Override
    public Student saveStudent(Student student){
       return studentDao.save(student);
    }
    @Override
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        studentDao.findAll().forEach(students::add);
        return students;
    }
    @Override
    public Optional<Student> findStudentbyRollnum(String Id){
        return studentDao.findById(Id);
    }
    @Override
    public void delStudent(String Id){
        studentDao.deleteById(Id);

    }
    @Override
    public Student updateStudent(Student student,String Id){
        Student studentDB = studentDao.findById(Id).get();
        if ( Objects.nonNull(student.getName())
                && !"".equalsIgnoreCase(
                student.getName())) {
            studentDB.setName(
                    student.getName());
        }
        if ( Objects.nonNull(student.getDepartment())
                && !"".equalsIgnoreCase(
                student.getDepartment())) {
            studentDB.setDepartment(
                    student.getDepartment());
        }
        if ( Objects.nonNull(student.getDate())) {
            studentDB.setDate(
                    student.getDate());
        }
        return studentDao.save(studentDB);
    }
    @Override
    public List<Student> findStudentByName(String name){
        return studentDao.findStudentByName(name);
    }
    @Override
    public List<Student> findStudentByStudentDepartment(String department ){
        return studentDao.findStudentByStudentDepartment(department);
    }
}
