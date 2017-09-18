package main.java.antra.test;

import static org.junit.Assert.assertTrue;
import main.java.antra.deptemp.config.MvcConfig;
import main.java.antra.deptemp.config.PersistenceJPAConfig;
import main.java.antra.deptemp.entity.Department;
import main.java.antra.deptemp.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class,PersistenceJPAConfig.class})
@WebAppConfiguration
public class UnitTest_4SpringIntegretionTest {

    @Autowired
    DepartmentService deptService;


    @Test
    public void testDeptService() {
        List<Department> list = deptService.loadDeptBasicInfo();
        list.forEach(System.out::println);
        assertTrue(list.isEmpty());
    }

    @Test(expected = Exception.class)
    public void testDeptServiceSave() {
        Department dept = new Department();
        dept.setName("Test_dept");
        deptService.saveDept(dept);
    }
}
