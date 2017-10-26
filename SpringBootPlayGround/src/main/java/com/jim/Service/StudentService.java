package com.jim.Service;

import com.jim.DAO.FakeStudentDaoImpl;
import com.jim.DAO.StudentDao;
import com.jim.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;



@Service
public class StudentService {

    @Autowired
    @Qualifier("mysql")
    private StudentDao StudentDao;


    public Collection<Student> getAllStudents() {
        return StudentDao.getAllStudents();
    }

    public Student getStudentById(int id) {
        return StudentDao.getStudentById(id);
    }

    public void removeStudentById(int id) {
        this.StudentDao.removeStudentById(id);
    }

    public void updateStudent(Student student) {
        System.out.println(" service"+student.getCourse());
        this.StudentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        StudentDao.insertStudentToDb(student);
    }
}
