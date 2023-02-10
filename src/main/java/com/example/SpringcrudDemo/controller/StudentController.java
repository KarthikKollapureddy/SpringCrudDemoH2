package com.example.SpringcrudDemo.controller;

import com.example.SpringcrudDemo.model.Student;
import com.example.SpringcrudDemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.awt.*;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        Student newStudent = studentService.saveStudent(student);
        return new ResponseEntity<Student>(newStudent,HttpStatus.CREATED );
    }
//    @GetMapping("test")
//    public String testgetData(){
//        return "Working";
//    }
    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<List<Student>>(students,HttpStatus.FOUND);
    }

    @GetMapping("{name}")
    public ResponseEntity<List<Student>> findStudentByName(@PathVariable String name){
        List<Student> student = studentService.findStudentByName(name);
        return new ResponseEntity<List<Student>>(student,HttpStatus.FOUND);
    }

    @GetMapping("/studentinfo/{Id}")
    public Optional<Student> findStudentbyRollnum(@PathVariable String Id){
        return studentService.findStudentbyRollnum(Id);
    }

    @GetMapping("department/{department}")
    public ResponseEntity<List<Student>> findStudentByDepartment(@PathVariable String department){
        List<Student> dept = studentService.findStudentByStudentDepartment(department);
        return new ResponseEntity<List<Student>>(dept,HttpStatus.FOUND);
    }

    @PutMapping("updatestudent/{Id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable String Id){
        return studentService.updateStudent(student,Id);
    }
    @DeleteMapping("delstudent/{Id}")
        public String delStudent(@PathVariable String Id){
            studentService.delStudent(Id);
            return "Student with RollNum "+Id+" deleted successfully";

        }
}
