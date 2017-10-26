package com.jim.DAO;

import com.jim.Entity.Student;

import java.util.Collection;
import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents();

    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void insertStudentToDb(Student student);
}
