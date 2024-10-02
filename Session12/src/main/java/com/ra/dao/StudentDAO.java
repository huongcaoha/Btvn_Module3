package com.ra.dao;

import com.ra.model.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getListStudent();
    boolean addStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(int id) ;
    Student getStudentById(int id);
}
