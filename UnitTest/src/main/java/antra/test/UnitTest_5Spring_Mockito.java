package main.java.antra.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import main.java.antra.deptemp.dao.DepartmentDAO;
import main.java.antra.deptemp.entity.Department;
import main.java.antra.deptemp.service.DepartmentServiceImpl;

public class UnitTest_5Spring_Mockito {
    @Mock
    private DepartmentDAO deptDAO;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockGet() {
        List<Department> resList = new ArrayList<Department>();
        resList.add(new Department());
        resList.add(new Department());

        when(deptDAO.findAllDepartments()).thenReturn(resList);

        assertEquals(2, deptDAO.findAllDepartments().size());
    }

    @Test(expected = RuntimeException.class)
    public void testMockSave() {
        doThrow(new SQLException()).when(deptDAO).save(anyObject());
        DepartmentServiceImpl ds = new DepartmentServiceImpl();
        ds.setDeptDAO(deptDAO);
        ds.saveDept(new Department());
    }

    @Test
    public void testMockSaveGood() {
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                System.out.println("called save with arguments: " + Arrays.toString(args));
                return null;
            }
        }).when(deptDAO).save(anyObject());


        DepartmentServiceImpl ds = new DepartmentServiceImpl();
        ds.setDeptDAO(deptDAO);
        Department dept = new Department();
        dept.setName("AnotherTestDept");
        ds.saveDept(dept);
    }
}
