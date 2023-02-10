package com.example.SpringcrudDemo.dao;

import com.example.SpringcrudDemo.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends CrudRepository<Student,String> {
//here a query is generated automatically by Spring Boot [Select * from Students WHERE name = ?]
    public List<Student> findStudentByName(String name);

//    for custom or complex Query we can make use of @Query("<Query>")
    @Query("select p from Student p where p.department=:department")
    public List<Student> findStudentByStudentDepartment(@Param("department") String department);

}
