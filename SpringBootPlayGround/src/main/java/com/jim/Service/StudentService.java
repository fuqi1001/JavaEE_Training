package com.jim.Service;

import com.jim.Entity.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
