package com.jim;


import com.jim.Controller.StudentController;
import com.jim.DAO.StudentDao;
import com.jim.Entity.Student;
import com.jim.Service.StudentService;
import com.jim.Service.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTest {

    @Mock
    StudentDao studentDao;

    @InjectMocks
    StudentServiceImpl studentServiceImpl;

    @Mock
    StudentServiceImpl studentServiceImplMock;

    @InjectMocks
    StudentController studentControllerMock;

    private Student student = new Student();
    private Integer id = 99;
    private String name = "mockname";
    private String course = "mockcourse";

    private List<Student> testList = new ArrayList<>();

    @Before
    public void initTest() {
        student.setId(id);
        student.setName(name);
        student.setCourse(course);

        testList.add(student);
    }

    @Test
    public void testGetStudent() {
        when(studentDao.getStudentById(id)).thenReturn(student);
        assertEquals(studentServiceImpl.getStudentById(id).toString(), student.toString());
    }

    @Test
    public void testGetAllStudent() {
        when(studentDao.getAllStudents()).thenReturn(testList);
        assertTrue(studentServiceImpl.getAllStudents().size() == 1 &&
                studentServiceImpl.getAllStudents().get(0).toString().equals(testList.get(0).toString()));
    }



}
