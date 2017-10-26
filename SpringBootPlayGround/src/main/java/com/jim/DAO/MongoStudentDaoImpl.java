package com.jim.DAO;

import com.jim.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Repository
@Qualifier("MongoData")
public class MongoStudentDaoImpl implements StudentDao {
    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<Student>(){
            {add(new Student(1, "Mario", "Nothing"));}
        };
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void removeStudentById(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudentToDb(Student student) {

    }
}
