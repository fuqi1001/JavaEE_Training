package com.jim.DAO;

import com.jim.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {

    private static Map<Integer, Student> students;
    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "one", "CS"));
                put(2, new Student(2, "two", "CS"));
                put(3, new Student(3, "three", "CS"));
                put(4, new Student(4, "four", "CS"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents() {
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return this.students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {

        //Student student1 = students.get(student.getId());
        //System.out.println(" Dao"+student.getCourse());
        //student1.setCourse(student.getCourse());
        //student1.setName(student.getName());
        students.put(student.getId(), student);
    }

    @Override
    public void insertStudentToDb(Student student) {
        students.put(student.getId(), student);
    }
}
