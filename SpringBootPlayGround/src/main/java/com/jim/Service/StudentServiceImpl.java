package com.jim.Service;

import com.jim.DAO.FakeStudentDaoImpl;
import com.jim.DAO.StudentDao;
import com.jim.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    @Qualifier("mysql")
    private StudentDao StudentDao;


    @Override
    public List<Student> getAllStudents() {
        return StudentDao.getAllStudents();
    }

    @Override
    public Student getStudentById(int id) {
        return StudentDao.getStudentById(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.StudentDao.removeStudentById(id);
    }

    @Override
    public void updateStudent(Student student) {
        System.out.println(" service"+student.getCourse());
        this.StudentDao.updateStudent(student);
    }

    @Override
    public void insertStudent(Student student) {
        StudentDao.insertStudentToDb(student);
    }
}
